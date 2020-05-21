<template>
  <q-layout>
    <q-layout-header>
      <q-toolbar class="bg-primary text-white">
        <q-toolbar-title>
          5e Character sheet creator
          <div slot="subtitle">{{ $t("runningOnTag") }} Quasar v{{ $q.version }}</div>
        </q-toolbar-title>
        <q-select
          inverted
          v-model="lang"
          :options="langOptions"
          standout="bg-primary text-white"
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

