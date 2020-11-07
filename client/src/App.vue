<template>
  <v-app>
    <v-app-bar app color="secondary" >
      <v-toolbar-title>Сокращатель ссылок</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn v-if="isAuthenticated" @click="logout" dark>Выйти</v-btn>
    </v-app-bar>

    <v-main>
      <router-view @login="doLogin" :user="user" ></router-view>
    </v-main>
  </v-app>
</template>
<script>
export default {
  components: {},
  data : () => ({
    isAuthenticated : false,
    user : null
  }),
  methods : {
    logout() {
      this.$axios.post('/logout').then(() => {
        this.isAuthenticated = false
        this.user = null
        this.$router.push('/login')
      })
    },
    doLogin() {
      this.loadUser()
    },
    loadUser() {
      return  this.$axios.get('/user/info').then(res => {
        this.user = res.data
        this.isAuthenticated = true
        this.$router.push('/')
      }).catch(() => {
        this.isAuthenticated = false
        this.user = null
        this.$router.push('/login')
      })
    }
  },
  mounted() {
    this.loadUser()
  }
}
</script>
