<template>
  <div class="appBar">
    <v-app-bar
      dense
      dark
    >
      <v-btn
        fab
        small
        color="primary"
        depressed
        style="background-color: cornflowerblue"
      >
        로고<br>
        자리
      </v-btn>

      <v-spacer/>
      <div class="appBarMidIcon" style="margin: 30px">
        <v-btn icon style="margin: 35px">
          <v-icon>mdi-home</v-icon>
        </v-btn>
        <v-btn icon style="margin: 35px">
          <v-icon>mdi-account-multiple</v-icon>
        </v-btn>
        <v-btn icon style="margin: 35px">
          <v-icon>mdi-youtube</v-icon>
        </v-btn>
      </div>

      <v-spacer/>
      <div class="appBarRightIcon">
        <v-btn depressed>
          <span>Lee Min Ho</span>
        </v-btn>
        <v-btn icon>
          <v-icon>mdi-android-messages</v-icon>
        </v-btn>
        <v-btn icon>
          <v-icon>mdi-bell</v-icon>
        </v-btn>
        <v-btn icon>
          <v-icon>mdi-chevron-down</v-icon>
        </v-btn>
      </div>
    </v-app-bar>
  </div>
</template>

<script>
</script>
<style src="@/assets/firstLayout.css" scoped/>
