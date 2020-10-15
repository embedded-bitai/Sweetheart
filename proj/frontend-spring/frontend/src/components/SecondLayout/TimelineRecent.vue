<template>
  <v-container class="pa-0">
    <v-layout class="ml-10 mr-10">
      <v-flex class="text-h6">
        <v-col>
          <v-row class="mb-2">
            Visit
          </v-row>
          <v-icon class="justify-center" style="text-align: center;" size="250%">mdi-cart-arrow-right</v-icon>
          50 pers
        </v-col>
      </v-flex>
      <v-flex class="text-h6" style="text-align: center">
        <v-col>
          <v-row class="mb-2 justify-center">
            My Friend
          </v-row>
          <v-icon size="250%" class="ml-10">mdi-cart-arrow-right</v-icon>
          50 pers
        </v-col>
      </v-flex>
      <v-flex class="text-h6" style="text-align: right;">
        <v-col>
          <v-row class="mb-2 justify-end mr-8">
            Message
          </v-row>
          <v-icon size="250%" color="green lighten-1">mdi-trending-up</v-icon>
          +30
        </v-col>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  name: 'TimelineRecent'
}
</script>
