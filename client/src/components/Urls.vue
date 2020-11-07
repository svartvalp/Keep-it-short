<template>
    <v-container >
      <v-dialog v-model="dialog" max-width="300px">
        <v-card>
          <v-text-field v-model="urlTo" label="Ссылка"></v-text-field>
          <v-text-field v-model="comment" label="Комментарий"></v-text-field>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" text @click="cancel">Cancel</v-btn>
            <v-btn color="blue darken-1" text @click="save">OK</v-btn>
            <v-spacer></v-spacer>
          </v-card-actions>
        </v-card>
      </v-dialog>
      <v-card>
        <v-card-title>
          Ваши ссылки
          <v-spacer></v-spacer>
          <v-btn @click="openDialog" >Добавить</v-btn>
        </v-card-title>
        <v-data-table
            :headers="headers"
            :items="items"
        >
          <template v-slot:item.actions="{ item }">
            <v-icon
                small
                class="mr-2"
                @click="deleteUrl(item)"
            >
              mdi-delete
            </v-icon>
          </template>
          <template v-slot:item.urlFrom="{ item }">
            <a :href="item.urlFrom">{{item.urlFrom}}</a>
          </template>
          <template v-slot:item.urlTo="{ item }">
            <a :href="item.urlTo">{{item.urlTo}}</a>
          </template>
        </v-data-table>
      </v-card>
    </v-container>
</template>
<script>
export default {
  props : {
    user : Object
  },
  methods : {
    deleteUrl(item) {
      this.$axios.delete(`/url/${item.id}`).then(() => {
        this.items = this.items.filter(it => it.id !== item.id)
      })
    },
    openDialog() {
      this.dialog = true
    },
    save() {
      let url = {
        userId : this.user.id,
        urlTo : this.urlTo,
        comment : this.comment
      }
      this.$axios.post('/url', url).then(res => {
        this.items.push(res.data)
        this.dialog = false
      })
    },
    cancel() {
      this.dialog = false
      this.urlTo = ''
      this.comment = ''
    },
    loadItems() {
      console.log(this.user)
      this.$axios.get(`/url/user/${this.user.id}`).then(res => {
        this.items = res.data
      })
    }
  },
  mounted() {
    if(this.user) {
      this.$nextTick(() => {
        this.loadItems()
      })
    } else {
      setTimeout(() => this.loadItems(), 300)
    }
  },
  data : () => ({
    headers : [
      {
        text : 'Сокращенная ссылка',
        value : 'urlFrom'
      },
      {
        text: 'Полная ссылка',
        value: 'urlTo'
      },
      {
        text : 'Комментарий',
        value : 'comment'
      },
      {
        value: 'actions'
      }
    ],
    items : [],
    dialog : false,
    urlTo : '',
    comment : ''
  })
}
</script>