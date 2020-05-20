<template>
  <div class="q-pa-md">
    <q-stepper v-model="step" ref="stepper" color="primary" animated>
      <q-step :name="1" title="Choose race" icon="settings" :done="step > 1">
        <template>
          <div class="q-pa-md" style="max-width: 300px">
            <div class="q-gutter-md">
              <q-select v-model="raceSelected" :options="races" label="Standard" filled />
            </div>
            <span>Selected: {{ raceSelected }}</span>
          </div>
        </template>
      </q-step>

      <q-step
        :name="2"
        title="Choose background"
        caption="Optional"
        icon="create_new_folder"
        :done="step > 2"
      >
        <template>
          <div class="q-pa-md" style="max-width: 300px">
            <div class="q-gutter-md">
              <form>
                <q-select v-model="backgroundSelected" :options="backgrounds" label="Standard" />
              </form>
              <span>Selected: {{ backgroundSelected }}</span>
            </div>
          </div>
        </template>
      </q-step>

      <q-step :name="3" title="Choose class" icon="assignment">
        <template>
          <div class="q-pa-md" style="max-width: 300px">
            <div class="q-gutter-md">
              <q-select
                v-model="specializationSelected"
                :options="specializations"
                label="Standard"
              />
            </div>
            <span>Selected: {{ specializationSelected }}</span>
          </div>
        </template>
      </q-step>

      <q-step :name="4" title="Choose subclass" icon="assignment">
        <template>
          <div class="q-pa-md" style="max-width: 300px">
            <div class="q-gutter-md">
              <q-select
                v-model="subclassSelected"
                :options="
                  subclasses.filter(
                    item => item.class === specializationSelected
                  )
                "
                label="Standard"
              />
              <span>Selected: {{ subclassSelected }}</span>
            </div>
            <br />
          </div>
        </template>
      </q-step>

      <q-step :name="5" title="Create Character" icon="add_comment">
        <ul>
          <li>
            Race: {{ raceSelected ? (races.find(
            item => item.value === raceSelected
            )).label : 'Please choose your race.' }}
          </li>
          <li>
            Background: {{ backgroundSelected ? (backgrounds.find(
            item => item.value === backgroundSelected
            )).label : 'Please choose your background.' }}
          </li>
          <li>
            Class: {{ specializationSelected ? (specializations.find(
            item => item.value === specializationSelected
            )).label : 'Please choose your class.' }}
          </li>
          <li>
            Subclass: {{ subclassSelected ? (subclasses.find(
            item => item.value === subclassSelected
            )).label : 'Please choose your subclass.' }}
          </li>
        </ul>
      </q-step>

      <template v-slot:navigation>
        <q-stepper-navigation>
          <q-btn
            v-if="step > 1"
            flat
            color="primary"
            @click="$refs.stepper.previous()"
            label="Back"
            class="q-ml-sm"
          />
          <q-btn
            v-on:click="step === 5 ? create_char(raceSelected,backgroundSelected,specializationSelected,subclassSelected) :$refs.stepper.next() "
            color="primary"
            :label="step === 5 ? 'Finish' : 'Continue'"
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
      subclassSelected
    ) {
      let warning = "";
      if (!raceSelected) warning = warning + "Select race! \n";
      if (!backgroundSelected) warning = warning + "Select background! \n";
      if (!specializationSelected) warning = warning + "Select class! \n";
      if (!subclassSelected) warning = warning + "Select subclass! \n";
      if (warning) return alert(warning);
      axios
        .get(
          `http://localhost:8080/character?classId=${specializationSelected}&subclassId=${subclassSelected}&backgroundId=${backgroundSelected}&raceId=${raceSelected}`
        )
        .then(response => {
          this.pdf = response.data;
        })
        .catch(e => {
          this.errors.push(e);
        });
      console.log(this.pdf);
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
      pdf: ""
    };
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
            class: element.classId
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

<style></style>
