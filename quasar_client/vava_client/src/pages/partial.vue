<template>
  <div class="q-pa-md">
    <q-stepper
      v-model="step"
      ref="stepper"
      color="primary"
      animated
    >
      <q-step
        :name="1"
        title="Choose race"
        icon="settings"
        :done="step > 1"
      >
        <template>
            <q-page padding>
              <q-list highlight>
                <q-list-header>Choose your race:</q-list-header>
                  <q-item v-for="race in races" v-bind:key="race.name">
                    <q-item-main :label="race.name" />
                  </q-item>
              </q-list>
            </q-page>
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
          <q-page padding>
            <q-list highlight>
              <q-list-header>Choose your background:</q-list-header>
                <q-item v-for="background in backgrounds" v-bind:key="background.name">
                  <q-item-main :label="background.name" />
                </q-item>
            </q-list>
          </q-page>
        </template>
      </q-step>

      <q-step
        :name="3"
        title="Choose class"
        icon="assignment"
        
      >
        
        <template>
            <q-page padding>
              <q-list highlight>
                <q-list-header>Choose your class:</q-list-header>
                  <q-item v-for="specialization in specializations" v-bind:key="specialization.name">
                    <q-item-main :label="specialization.name" />
                  </q-item>
              </q-list>
            </q-page>
          </template>

      </q-step>

      <q-step
        :name="4"
        title="Choose subclass"
        icon="assignment"
        
      >
        
        <template>
            <q-page padding>
              <q-list highlight>
                <q-list-header>Choose your class:</q-list-header>
                  <q-item v-for="subclass in subclasses" v-bind:key="subclass.name">
                    <q-item-main :label="subclass.name" />
                  </q-item>
              </q-list>
            </q-page>
          </template>

      </q-step>

      <q-step
        :name="5"
        title="Create Character"
        icon="add_comment"
      >
      
      </q-step>

      <template v-slot:navigation>
        <q-stepper-navigation>
          <q-btn @click="$refs.stepper.next()" color="primary" :label="step === 4 ? 'Finish' : 'Continue'" />
          <q-btn v-if="step > 1" flat color="primary" @click="$refs.stepper.previous()" label="Back" class="q-ml-sm" />
        </q-stepper-navigation>
      </template>
    </q-stepper>
  </div>

</template>