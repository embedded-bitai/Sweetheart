<template>
  <div class="fistLeftSideMenu">
    <v-layout column>
      <v-flex>
        <v-btn depressed style="background-color: rgba(255,255,255,0.0); color: white; margin-bottom: 10px; font-size: 20px">
          <v-img src="https://cdn.vuetifyjs.com/images/john.jpg"
                 width="25px"
          ></v-img>
          <span>LeeMinHo</span>
        </v-btn>
      </v-flex>
      <v-flex>
        <v-btn
          depressed style="background-color: rgba(255,255,255,0.0); color: white; margin-bottom: 10px; font-size: 20px">
          <v-icon>mdi-account-multiple</v-icon>
          <span>Friends</span>
        </v-btn>
      </v-flex>
      <v-flex>
        <v-btn depressed style="background-color: rgba(255,255,255,0.0); color: white; margin-bottom: 10px; font-size: 20px">
          <v-icon>mdi-chat</v-icon>
          <span>chat</span>
        </v-btn>
      </v-flex>
      <v-flex>
        <v-btn depressed style="background-color: rgba(255,255,255,0.0); color: white; margin-bottom: 10px; font-size: 20px">
          <v-icon>mdi-video</v-icon>
          <span>Video</span>
        </v-btn>
      </v-flex>
      <v-divider></v-divider>
    </v-layout>
  </div>
</template>

<style src="@/assets/firstLayout.css" scoped/>
