<template>
  <q-page padding>
    <q-list highlight>
      <q-list-header>Users list</q-list-header>
        <q-item v-for="user in users" v-bind:key="user.name">
          <q-item-main :label="user.name" />
        </q-item>
    </q-list>
  </q-page>
</template>
  
<script>
import axios from 'axios'

export default {
  // name: 'PageName',
  data: function () {
    return {
      users: []
    }
  },
  created () {
    axios.get('http://localhost:8080/character/backgrounds')
      .then(response => {
        this.users = response.data
      })
      .catch(e => {
        this.errors.push(e)
      })
  }
}
</script>
  
<style>
</style>