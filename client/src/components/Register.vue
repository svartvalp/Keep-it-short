<template>
    <v-container class="fill-height" >
    <v-row align="center" justify="center">
      <v-card min-width="400px" max-width="500px" >
        <v-card-title>Регистрация</v-card-title>
        <v-text-field v-model="login" label="Логин" ></v-text-field>
        <v-text-field v-model="password" :type="'password'" label="Пароль"></v-text-field>
        <v-card-actions>
        <v-btn @click="doRegister" >Зарегистрироваться</v-btn>
          <v-spacer></v-spacer>
        <v-btn @click="doLogin" >Войти</v-btn>
        </v-card-actions>
      </v-card>
    </v-row>
    </v-container>
</template>
<script>
export default {
  data : () => ({
    login : '',
    password : ''
  }),
  methods : {
    doRegister() {
      let user = {
        login : this.login,
        password : this.password
      }
      this.$axios.post('/register', user).then(() => {
        this.$router.push('/login')
      })
    },
    doLogin() {
      this.$router.push('/login')
    }
  }
}
</script>