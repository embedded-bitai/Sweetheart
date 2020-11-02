<template>
  <v-card style="margin: 10px; padding: 10px; width: 100%; height: auto; ">
    <h2 id="top_area" style="margin: 10px 10px 25px 10px; width: 100%; height: 5%">Personal Detail</h2><hr>
    <v-layout id="contents_area">
    <v-flex id="left_area" style="width: 50%; height: max-content">
      <h2 style="margin-top: 35px; padding: 5px; color: black">Gender</h2>
      <h2 style="margin-top: 1px; padding: 5px; color: dimgray">{{ userGender }}</h2>
      <h2 style="margin-top: 35px; padding: 5px; color: black">Blood Group</h2>
      <h2 style="margin-top: 1px; padding: 5px; color: dimgray">{{ userBlood }}</h2>
      <h2 style="margin-top: 35px; padding: 5px; color: black">Permanent Address</h2>
      <h2 style="margin-top: 1px; padding: 5px; color: dimgray">{{ userPerAddr }}</h2>
      <h2 style="margin-top: 35px; padding: 5px; color: black">Residential Address</h2>
      <h2 style="margin-top: 1px; padding: 5px; color: dimgray">{{ userResAddr }}</h2>
    </v-flex>
    <v-flex id="middle_area" style="width: 49%">
      <h2 style="margin-top: 35px; padding: 5px; color: black">Date of Birth</h2>
      <h2 style="margin-top: 1px; padding: 5px; color: dimgray">{{ userBirth }}</h2>
      <h2 style="margin-top: 35px; padding: 5px; color: black">Registered Email</h2>
      <h2 style="margin-top: 1px; padding: 5px; color: dimgray">{{ userEmail }}</h2>
    </v-flex>
      <v-flex id="right_area" style="width: 5%">
        <div style="margin-top:10px; padding: 1px">
          <v-btn depressed small white color="dimgray" style="background-color: rgba(255,255,255,0.0)" fab>
            <v-icon>mdi-lead-pencil</v-icon>
          </v-btn>
        </div>
      </v-flex>
  </v-layout>
  </v-card>
</template>

<script>
export default {
  data () {
    return {
      userGender: this.$store.state.myProfile[0].userGender,
      userBirth: this.$store.state.myProfile[0].date,
      userBlood: '',
      userEmail: this.$store.state.myProfile[0].userEmail,
      userPerAddr: '',
      userResAddr: this.$store.state.myProfile[0].totalAddress
    }
  }
}
</script>
