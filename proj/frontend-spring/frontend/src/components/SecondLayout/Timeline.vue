<template>
  <v-card
    class="grey lighten-3 scroll"
    outline
    style="height: 100%; max-height: 100%; width: 100%; max-width: 100%">
    <v-layout>
      <TimeLineHeader style="border-radius: 10vh"></TimeLineHeader>
    </v-layout>
    <v-layout>
      <TimelineRecent></TimelineRecent>
    </v-layout>
    <v-layout id="contents_area">
      <v-flex id="left_area" style="width: 50%; height: max-content">
        <v-layout column>
          <TimeLineGuestBook></TimeLineGuestBook>
          <TimeLineChatList></TimeLineChatList>
        </v-layout>
      </v-flex>
      <v-flex id="right_area" style="width: 50%">
        <TimeLinePost></TimeLinePost>
      </v-flex>
    </v-layout>
  </v-card>
</template>

<script>
import TimeLineHeader from '@/components/SecondLayout/TimeLineHeader'
import TimelineRecent from '@/components/SecondLayout/TimelineRecent'
import TimeLineGuestBook from '@/components/SecondLayout/TimeLineGuestBook'
import TimeLineChatList from '@/components/SecondLayout/TimeLineChatList'
import TimeLinePost from '@/components/SecondLayout/TimeLinePost'

export default {
  name: 'Timeline',
  components: {
    TimeLinePost,
    TimeLineChatList,
    TimeLineGuestBook,
    TimelineRecent,
    TimeLineHeader
  }
}
</script>
