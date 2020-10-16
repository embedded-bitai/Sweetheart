<template>
  <v-container>
    <v-layout class="text-h5 mb-7 mt-5 ml-10">
      Sweet Hearts
    </v-layout>
    <v-layout
      column
    >
      <v-col class="pa-0">
        <p class="text-h3 ml-10">Login</p>
      </v-col>
      <v-col class="pa-0">
        <v-text-field
          single-line
          label="Email Address"
          class="mr-10 ml-10"
        ></v-text-field>
      </v-col>
      <v-col class="pa-0">
        <v-text-field
          single-line
          label="Password"
          class="mr-10 ml-10"
        ></v-text-field>
        <p class="mr-10" style="text-align: right">Sign Up</p>
      </v-col>
      <v-col>
        <v-card shaped width="90%">
          <v-btn class="white primary--text" width="100%">ENTRAR</v-btn>
        </v-card>
      </v-col>
      <v-col>
        <v-card shaped width="90%">
          <v-btn class="primary" width="100%">Forgot Password?</v-btn>
        </v-card>
      </v-col>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  name: 'SignInCompo'
}
</script>
