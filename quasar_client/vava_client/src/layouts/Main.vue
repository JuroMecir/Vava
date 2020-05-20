<template>
  <q-layout>
    <q-layout-header>
      <q-toolbar :glossy="$q.theme === 'mat'" :inverted="$q.theme === 'ios'">
        <q-toolbar-title>
          5e Character sheet creator
          <div slot="subtitle">
            {{ $t("runningOnTag") }} Quasar v{{ $q.version }}
          </div>
        </q-toolbar-title>
        <q-select
          v-model="lang"
          :options="langOptions"
          label="Quasar Language"
          justify-center
          dense
          standout="bg-primary text-white"
          emit-value
          map-options
          options-dense
          style="min-width: 150px"
        />
      </q-toolbar>
    </q-layout-header>

    <q-page-container>
      <!-- This is where pages get injected -->
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
export default {
  data: function() {
    return {
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
  }
};
</script>
