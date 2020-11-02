<template>
  <v-card style="margin: 10px; padding: 10px; width: 100%; height: auto; ">
    <v-layout id="contents_area">
      <v-flex id="left_area" style="width: 10%; height: max-content">
        <v-img
          v-if="userImg"
          style="margin: 10px; padding: 10px"
          class="justify-center v-img"
          :src=this.userDefaultImg
          max-width="200"
        ></v-img>
        <v-img
          v-else
          style="margin: 10px; padding: 10px"
          class="justify-center v-img"
          :src=this.userDefaultImg
          max-width="200"
        ></v-img>
      </v-flex>
      <v-flex id="middleLeft_area" style="width: 29%">
        <div style="padding: 10px">
          <h2>{{ userJob }} {{ userCompany }}</h2>
          <h2>{{ userJobDate }}</h2>
          <h2 style="color: cornflowerblue">Reset Password</h2>
        </div>
      </v-flex>
      <v-flex id="middle_area" style="width: 30%">
        <div style="padding: 10px">
          <h2 style="color: cornflowerblue">{{ userJobEmail }}</h2>
          <h2 style="color: cornflowerblue">09P02308</h2>
        </div>
      </v-flex>
      <v-flex id="middleRight_area" style="width: 30%">
        <div style="padding: 10px">
          <h2 style="color: cornflowerblue">{{ userPhone }}</h2>
        </div>
      </v-flex>
      <v-flex id="right_area" style="width: 5%">
        <v-btn depressed small white color="dimgray" style="background-color: rgba(255,255,255,0.0)" fab>
          <v-icon>mdi-lead-pencil</v-icon>
        </v-btn>
      </v-flex>
    </v-layout>
  </v-card>
</template>

<script>
export default {
  data () {
    return {
      userImg: '',
      userDefaultImg: require('../../assets/blank-profile-picture-973460_1280.png'),
      userJob: '',
      userCompany: '',
      userJobDate: '',
      userJobEmail: '',
      userPhone: ''
    }
  }
}
</script>
