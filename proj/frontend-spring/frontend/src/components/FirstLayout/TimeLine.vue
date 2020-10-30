<template>
  <div class="timeLine">
    <v-layout style="margin: 0 0 10px 0">
      <TimeLinePost/>
    </v-layout>
    <TimeLineFeed/>
  </div>
</template>

<style src="@/assets/firstLayout.css" scoped/>
<script>
import TimeLinePost from '@/components/FirstLayout/TimeLinePost'
import TimeLineFeed from '@/components/FirstLayout/TimeLineFeed'
export default {
  components: {
    TimeLinePost,
    TimeLineFeed
  }
}
</script>
