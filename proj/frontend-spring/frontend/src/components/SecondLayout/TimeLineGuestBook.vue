<template>
  <v-container class="pa-5">
    <v-card>
      <v-toolbar class="blue lighten-5" flat outlined width="100%" height="40%">
        <v-icon color="purple">mdi-lead-pencil</v-icon>
        <v-subheader>Status</v-subheader>
        <v-spacer></v-spacer>
        <input type="file" @change="onFileChange">
        <v-icon color="green">mdi-camera</v-icon>
        <v-subheader>Picture</v-subheader>
        <v-spacer></v-spacer>
      </v-toolbar>
      <v-layout style="max-height: max-content">
        <v-flex class="ml-3" style="width: 15%; margin-top: 2%">
          <img
            src="https://cdn.vuetifyjs.com/images/john.jpg"
            style="max-width: 90%"
          >
        </v-flex>
        <v-flex class="ma-2" style="width: 85%; max-height: fit-content">
          <v-layout column id="preview">
            <img :src="image" />
            <v-textarea
              auto-grow
              rows="1"
              placeholder="무슨 생각을 하고 계신가요?"
              class="v-text-field--full-width"
              v-model="content"
            ></v-textarea>
          </v-layout>
        </v-flex>
      </v-layout>
      <v-layout justify-end>
        <v-btn @click="removeImage">Remove image</v-btn>
        <v-btn width="10%" class="primary ma-2" @click="upload_timeline">게시</v-btn>
      </v-layout>
    </v-card>
  </v-container>
</template>

<script>
import axios from 'axios'

export default {
  name: 'TimeLineGuestBook',
  data () {
    return {
      url: null,
      image: null,
      content: '',
      imageUrl: null,
      userNo: this.$store.state.myInfo.userNo
    }
  },
  methods: {
    upload_timeline () {
      console.log('payload - userNo: ' + this.userNo + ', image: ' + this.imageUrl + ', content: ' + this.content)
      const { userNo, imageUrl, content } = this
      axios.post('http://localhost:7777/timeline/register/',
        { userNo, imageUrl, content })
        .then(res => {
          console.log('register Success')
        })
        .catch(err => {
          alert(err.response.data)
        })
    },
    onFileChange (e) {
      var files = e.target.files || e.dataTransfer.files
      if (!files.length) {
        return
      }
      this.createImage(files[0])
    },
    createImage (file) {
      // var image = new Image()
      var reader = new FileReader()
      var vm = this

      reader.onload = (e) => {
        vm.image = e.target.result
      }
      reader.readAsDataURL(file)
    },
    removeImage: function (e) {
      this.image = ''
    }
  }
}
</script>
