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
        <div class="q-pa-md" style="max-width: 300px">
          <div class="q-gutter-md">
            <q-select v-model="model" :options="backgrounds" label="Standard" />
          </div>
        </div>
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
        
        asdsadsa

      </q-step>

      <q-step
        :name="5"
        title="Create Character"
        icon="add_comment"
      >
      
      </q-step>

      <template v-slot:navigation>
        <q-stepper-navigation>

          <q-btn v-if="step > 1" flat color="primary" @click="$refs.stepper.previous()" label="Back" class="q-ml-sm" />
          <q-btn @click="$refs.stepper.next()" color="primary" :label="step === 4 ? 'Finish' : 'Continue'" />
         
        </q-stepper-navigation>
      </template>
    </q-stepper>
  </div>

</template>

  
<script>
import axios from 'axios'

export default {
  // name: 'PageName',
  data: function () {
    return {
      backgrounds: [],
      races: [],
      specializations: [],
      subclasses: [],
      step: 1,
      model: 'Folk Hero'
    }
  },
  created () {
    axios.get('http://localhost:8080/character/backgrounds')
      .then(response => {
        this.backgrounds = response.data
        let temp = []
        this.backgrounds.forEach(element => {
          temp.push({label: element.name, value:element.id})
        });
        this.backgrounds = temp;
        console.log(this.backgrounds);
      })
      .catch(e => {
        this.errors.push(e)
      })
    
    axios.get('http://localhost:8080/character/races')
      .then(response => {
        this.races = response.data
      })
      .catch(e => {
        this.errors.push(e)
      }) 

      axios.get('http://localhost:8080/character/classes')
      .then(response => {
        this.specializations = response.data
      })
      .catch(e => {
        this.errors.push(e)
      })

    /*axios.get('http://localhost:8080/character/subclasses')
      .then(response => {
        this.subclasses = response.data
      })
      .catch(e => {
        this.errors.push(e)
      })  */
  }
}
</script>
  
<style>
</style>