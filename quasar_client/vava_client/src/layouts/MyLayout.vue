<template>
  <q-layout view="lHh Lpr lFf">
    <q-layout-header>
      <q-toolbar
        color="primary"
        :glossy="$q.theme === 'mat'"
        :inverted="$q.theme === 'ios'"
      >
        <q-toolbar-title>
          5e Character sheet creator
          <div slot="subtitle">Running on Quasar v{{ $q.version }}</div>
        </q-toolbar-title>
      </q-toolbar>
    </q-layout-header>
    <q-page-container>
      
    	<template>
		  <div class="q-pa-md">
		    <q-stepper
		      v-model="step"
		      ref="stepper"
		      color="primary"
		      animated
		    >
		      <q-step
		        :step="1"
		        title="Select race"
		        icon="settings"
		        :done="step > 1"
		      >
		        For each race...
		      </q-step>

		      <q-step
		        :step="2"
		        title="Select background"
		        icon="create_new_folder"
		        :done="step > 2"
		      >
		        For each background...
		      </q-step>

		      <q-step
		        :step="3"
		        title="Select race"
		        icon="assignment"
		        :done="step > 3"
		      >
		        For each race...
		      </q-step>

		      <q-step
		        :step="4"
		        title="Select subrace"
		        icon="add_comment"
		        :done="step > 4"

		      >
		        For each subrace...
		      </q-step>

		      <q-step
		        :step="5"
		        title="create pdf"
		        icon="settings"
		        
		      >
		        blabla
		      </q-step>

		      <template v-slot:navigation>
		        <q-stepper-navigation>
		          <q-btn @click="$refs.stepper.next()" color="primary" :label="step === 5 ? 'Finish' : 'Continue'" />
		          <q-btn v-if="step > 1" flat color="primary" @click="$refs.stepper.previous()" label="Back" class="q-ml-sm" />
		        </q-stepper-navigation>
		      </template>
		    </q-stepper>
		  </div>
		</template>

    </q-page-container>




  </q-layout>
</template>






<script>
import { openURL } from 'quasar'

export default {
  name: 'MyLayout',
  data () {
    return {
      leftDrawerOpen: this.$q.platform.is.desktop
    }
  },
  methods: {
    openURL
  }
}
</script>

<style>
</style>
