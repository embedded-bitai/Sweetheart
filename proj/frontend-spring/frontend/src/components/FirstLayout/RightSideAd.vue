<template>
  <div class="rightSideAd">
    <v-layout style="margin-top: 10px">
      <v-card style="width: 250px; height: 280px">
        <h1>Ad</h1>
      </v-card>
    </v-layout>
  </div>
</template>

<script>
export default {
  created () {
    this.$store.dispatch('crawlBitCamp')
  }
}
</script>

<style src="@/assets/firstLayout.css" scoped/>
