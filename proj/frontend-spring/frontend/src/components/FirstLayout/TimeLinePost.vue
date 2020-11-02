<template>
  <v-expansion-panels style="margin-top: 10px">
    <v-expansion-panel>
      <v-expansion-panel-header>
        <v-img
          v-if="userImg"
          src="https://cdn.vuetifyjs.com/images/john.jpg"
          width="25px"
        ></v-img>
        <v-img
          v-else
          :src=this.userDefaultImg
          max-width="40px"
        ></v-img>
        <h2 class="mt-2 ml-3">{{ userName }}</h2>
      </v-expansion-panel-header>
      <v-expansion-panel-content>
        <v-layout column>
          <v-flex>
            <v-textarea
              auto-grow
              rows="1"
              placeholder="anything?"
              v-model="content"
            ></v-textarea>
          </v-flex>
          <v-flex align-self-end>
            <!--      <input type="file" @change="onFileChange">-->
            <v-btn depressed fab small style="background-color: rgba(255,255,255,0.0)">
              <v-icon color="dimgray">mdi-file-upload</v-icon>
            </v-btn>
            <v-btn depressed fab small style="background-color: rgba(255,255,255,0.0)">
              <v-icon color="dimgray">mdi-file-cancel</v-icon>
            </v-btn>
            <v-btn @click="uploadFeed" depressed fab small style="background-color: rgba(255,255,255,0.0)">
              <v-icon>mdi-lead-pencil</v-icon>
            </v-btn>
          </v-flex>
        </v-layout>
      </v-expansion-panel-content>
    </v-expansion-panel>
  </v-expansion-panels>
</template>

<script>
import axios from 'axios'

export default {
  data () {
    return {
      userName: this.$store.state.myProfile[0].userName,
      userImg: '',
      userDefaultImg: require('../../assets/blank-profile-picture-973460_1280.png'),
      content: '',
      userNo: this.$store.state.myProfile[0].userNo
    }
  },
  methods: {
    uploadFeed () {
      console.log('uploadFeed()')
      const { userNo, userName, content } = this
      axios.post('http://localhost:7777/timeline/register/',
        { userNo, userName, content })
        .then(res => {
          console.log('uploadFeed then - res: ' + res)
          location.reload()
        })
        .catch(err => {
          alert(err.response.data)
        })
    }
  }
}
</script>
