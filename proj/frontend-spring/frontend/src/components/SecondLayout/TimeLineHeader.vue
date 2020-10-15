<template>
  <v-toolbar height="70%" style="background-color: rgba(255, 255, 255, 0)" flat>
    <p class="text-h6"
       style="position: absolute; z-index: 2; left: 5.5%; top: 30%">
      {{ day }}
    </p>
    <v-icon size="50" style="position: absolute; z-index: 1; left: 4%">mdi-calendar-blank</v-icon>
    <v-card class="white text-h6" width="10%" style="position: relative; text-align: center; left: 6.7%; z-index: 1">
      {{ month }} {{ year }}
    </v-card>
    <v-flex style="position: absolute; left: 30%">
      <v-btn
        depressed
        :color="interval1 == null ? 'white' : 'primary'"
        @click="interval1 == null ? start1() : stop1()"
      >Today
      </v-btn>
      <v-btn
        depressed
        :color="interval2 == null ? 'white' : 'primary'"
        @click="interval2 == null ? start2() : stop2()"
      >Week
      </v-btn>
      <v-btn
        depressed
        :color="interval3 == null ? 'white' : 'primary'"
        @click="interval3 == null ? start3() : stop3()"
      >Month
      </v-btn>
    </v-flex>
  </v-toolbar>
</template>

<script>
export default {
  name: 'TimeLineHeader',
  data () {
    return {
      day: new Date().getDate(),
      month: new Date().getMonth() + 1,
      year: new Date().getFullYear(),
      interval1: null,
      interval2: null,
      interval3: null
    }
  },
  methods: {
    start1 () {
      this.interval1 = setInterval(this.addEvent, 3000)
      this.stop2()
      this.stop3()
    },
    stop1 () {
      clearInterval(this.interval1)
      this.interval1 = null
    },
    start2 () {
      this.interval2 = setInterval(this.addEvent, 3000)
      this.stop1()
      this.stop3()
    },
    stop2 () {
      clearInterval(this.interval2)
      this.interval2 = null
    },
    start3 () {
      this.interval3 = setInterval(this.addEvent, 3000)
      this.stop1()
      this.stop2()
    },
    stop3 () {
      clearInterval(this.interval3)
      this.interval3 = null
    }
  }
}
</script>
