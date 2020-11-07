<template>
  <v-container class="fill-height" >
    <v-row justify="center" align="center" >
      <v-card min-width="400px" max-width="500px" >
        <v-card-title>Вход</v-card-title>
      <v-text-field v-model="login" label="Логин" ></v-text-field>
      <v-text-field v-model="password" :type="'password'" label="Пароль"></v-text-field>
        <v-card-actions>
          <v-btn @click="doLogin">Войти</v-btn>
          <v-spacer></v-spacer>
          <v-btn @click="doRegister">Зарегистрироваться</v-btn>
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
    doLogin() {
      this.$axios.post(`/login?username=${this.login}&password=${this.password}`).then(() => {
        this.$emit('login')
      })
    },
    doRegister() {
      this.$router.push('/register')
    }
  }
}
</script>