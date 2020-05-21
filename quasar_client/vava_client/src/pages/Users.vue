<template>
  <div class="q-pa-md">
    <q-stepper v-model="step" ref="stepper" color="primary" animated>
      <q-step :name="1" :title="$t('chooseRaceTag')" icon="settings" :done="step > 1">
        <template>
          <div class="q-pa-md" style="max-width: 300px">
            {{ $t("chooseRaceTag") }}:
            <div class="q-gutter-md">
              <q-select v-model="raceSelected" :options="races" label="Standard" filled />
            </div>
          </div>
        </template>
      </q-step>

      <q-step
        :name="2"
        :title="$t('chooseBackgroundTag')"
        caption="Optional"
        icon="create_new_folder"
        :done="step > 2"
      >
        <template>
          <div class="q-pa-md" style="max-width: 300px">
            <div class="q-gutter-md">
              {{ $t("chooseBackgroundTag") }}:
              <form>
                <q-select v-model="backgroundSelected" :options="backgrounds" label="Standard" />
              </form>
            </div>
          </div>
        </template>
      </q-step>

      <q-step :name="3" :title="$t('chooseClassTag')" icon="assignment">
        <template>
          <div class="q-pa-md" style="max-width: 300px">
            <div class="q-gutter-md">
              {{ $t("chooseClassTag") }}:
              <q-select
                v-model="specializationSelected"
                :options="specializations"
                label="Standard"
              />
            </div>
          </div>
        </template>
      </q-step>

      <q-step :name="4" :title="$t('chooseSubclassTag')" icon="assignment">
        <template>
          <div class="q-pa-md" style="max-width: 300px">
            <div class="q-gutter-md">
              {{ $t("chooseSubclassTag") }}:
              <q-select
                v-model="subclassSelected"
                :options="
                  subclasses.filter(
                    item => item.classId === specializationSelected
                  )
                "
                label="Standard"
              />
            </div>
          </div>
        </template>
      </q-step>

      <q-step :name="5" :title="$t('createCharacterTag')" icon="add_comment">
        <ul>
          {{ $t("createCharacterTag") }}:
          <li>
            {{ $t("raceTag") }}:
            {{
            raceSelected
            ? races.find(item => item.value === raceSelected).label
            : $t("raceMissingTag")
            }}
          </li>
          <li>
            {{ $t("backgroundTag") }}:
            {{
            backgroundSelected
            ? backgrounds.find(item => item.value === backgroundSelected)
            .label
            : $t("backgroundMissingTag")
            }}
          </li>
          <li>
            {{ $t("classTag") }}:
            {{
            specializationSelected
            ? specializations.find(
            item => item.value === specializationSelected
            ).label
            : $t("classMissingTag")
            }}
          </li>
          <li>
            {{ $t("subclassTag") }}:
            {{
            subclassSelected &&
            subclasses.find(item => item.value === subclassSelected) &&
            subclasses.find(item => item.value === subclassSelected)
            .classId === specializationSelected
            ? subclasses.find(item => item.value === subclassSelected).label
            : $t("subclassMissingTag")
            }}
          </li>
        </ul>
      </q-step>

      <template v-slot:navigation>
        <q-stepper-navigation order-first>
          <q-btn
            v-if="step > 1"
            flat
            color="primary"
            @click="$refs.stepper.previous()"
            :label="$t('backTag')"
            class="q-ml-sm"
          />
          <q-btn
            v-on:click="
              step === 5
                ? create_char(
                    raceSelected,
                    backgroundSelected,
                    specializationSelected,
                    subclassSelected,
                    subclasses,
                    $t('raceMissingTag'),
                    $t('classMissingTag'),
                    $t('subclassMissingTag'),
                    $t('backgroundMissingTag')
                  )
                : $refs.stepper.next()
            "
            color="primary"
            :label="step === 5 ? $t('createCharacterTag') : $t('continueTag')"
          />
        </q-stepper-navigation>
      </template>
    </q-stepper>
  </div>
</template>

<script>
import axios from "axios";

export default {
  // name: 'PageName',
  methods: {
    create_char: function(
      raceSelected,
      backgroundSelected,
      specializationSelected,
      subclassSelected,
      subclasses,
      raceMissingTag,
      classMissingTag,
      subclassMissingTag,
      backgroundMissingTag
    ) {
      let warnings = [];
      let x = 0;
      let num = 0;
      let temp = subclasses.find(item => item.value === subclassSelected);
      console.log(temp);
      if (!raceSelected) {
        warnings.push(raceMissingTag);
        num++;
      }
      if (!backgroundSelected) {
        warnings.push(backgroundMissingTag);
        num++;
      }
      if (!specializationSelected) {
        warnings.push(classMissingTag);
        num++;
      }
      if (!subclassSelected) {
        warnings.push(subclassMissingTag);
        x++;
        num++;
      }
      if (x === 0) {
        if (temp.classId !== specializationSelected)
          warnings.push(subclassMissingTag);
        num++;
      }

      if (warnings.toString()) {
        warnings.forEach(element =>
          this.$q.notify({
            message: element,
            color: "red",
            icon: "warning"
          })
        );
        return null;
      }

      location.href = `http://localhost:8080/character?classId=${specializationSelected}&subclassId=${subclassSelected}&backgroundId=${backgroundSelected}&raceId=${raceSelected}`;
    }
  },
  data: function() {
    return {
      backgrounds: [],
      races: [],
      specializations: [],
      subclasses: [],
      step: 1,
      raceSelected: "",
      backgroundSelected: "",
      specializationSelected: "",
      subclassSelected: "",
      pdf: "",
      lang: this.$i18n.locale,
      langOptions: [
        { value: "en-us", label: "English" },
        { value: "sk", label: "Slovak" }
      ]
    };
  },
  watch: {
    lang(lang) {
      this.$i18n.locale = lang;
    }
  },
  created() {
    axios
      .get("http://localhost:8080/character/backgrounds")
      .then(response => {
        this.backgrounds = response.data;
        let temp = [];
        this.backgrounds.forEach(element => {
          temp.push({ label: element.name, value: element.id });
        });
        this.backgrounds = temp;
        console.log(this.backgrounds);
      })
      .catch(e => {
        this.errors.push(e);
      });

    axios
      .get("http://localhost:8080/character/races")
      .then(response => {
        this.races = response.data;
        let temp = [];
        this.races.forEach(element => {
          temp.push({ label: element.name, value: element.id });
        });
        this.races = temp;
        console.log(this.backgrounds);
      })

      .catch(e => {
        this.errors.push(e);
      });

    axios
      .get("http://localhost:8080/character/classes")
      .then(response => {
        this.specializations = response.data;
        let temp = [];
        this.specializations.forEach(element => {
          temp.push({ label: element.name, value: element.id });
        });
        this.specializations = temp;
        console.log(this.specializations);
      })
      .catch(e => {
        this.errors.push(e);
      });

    axios
      .get("http://localhost:8080/character/subclasses")
      .then(response => {
        this.subclasses = response.data;
        let temp = [];
        this.subclasses.forEach(element => {
          temp.push({
            label: element.name,
            value: element.id,
            classId: element.classId
          });
        });
        this.subclasses = temp;
        console.log(this.subclasses);
      })
      .catch(e => {
        this.errors.push(e);
      });
  }
};

function create_char() {
  console.log("hi");
}
</script>

<style type="text/css">
.container {
  height: 200px;
  position: relative;
  border: 3px solid green;
}
</style>
