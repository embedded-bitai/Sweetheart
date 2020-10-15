<template>
  <v-app id="inspire">
    <v-container
      class="green"
      style="max-width: 100%; max-height: 100%; height: 100%"
    >
      <v-layout class="text-h5 white--text" justify-center>Sweat Hearts DarkTheme</v-layout>
      <v-layout fill-height justify-center>
        <v-card
          class="mt-10"
          height="85%"
          width="95%"
        >
          <v-layout fill-height>
            <v-flex
              style="max-width: 40%"
            >
              <v-carousel
                v-model="model"
                height="100%"
                hide-delimiters
              >
                <v-carousel-item>
                  <v-sheet
                    height="100%"
                    tile
                  >
                    <v-row
                      class="fill-height"
                      align="center"
                      justify="center"
                    >
                      <v-col
                        class="fill-height"
                        style="max-width: 40%"
                      >
                        <SignInCompo></SignInCompo>
                      </v-col>
                    </v-row>
                  </v-sheet>
                </v-carousel-item>
                <v-carousel-item>
                  <v-sheet
                    height="100%"
                    tile
                  >
                    <v-row
                      class="fill-height"
                      align="center"
                      justify="center"
                    >
                      <v-col class="primary fill-height">
                        <div class="display-3">
                          Slide 3
                        </div>
                      </v-col>
                    </v-row>
                  </v-sheet>
                </v-carousel-item>
              </v-carousel>
            </v-flex>
            <v-flex
              style="max-width: 60%;"
            >
              <v-carousel
                v-model="model"
                height="100%"
                hide-delimiters
              >
                <v-carousel-item>
                  <v-sheet
                    height="100%"
                    tile
                  >
                    <v-row
                      class="fill-height"
                      align="center"
                      justify="center"
                    >
                      <v-col class="error fill-height">
                        <div class="display-3">
                          Slide 2
                        </div>
                      </v-col>
                    </v-row>
                  </v-sheet>
                </v-carousel-item>
                <v-carousel-item>
                  <v-sheet
                    height="100%"
                    tile
                  >
                    <v-row
                      class="fill-height"
                      align="center"
                      justify="center"
                    >
                      <v-col class="primary fill-height">
                        <div class="display-3">
                          Slide 4
                        </div>
                      </v-col>
                    </v-row>
                  </v-sheet>
                </v-carousel-item>
              </v-carousel>
            </v-flex>
          </v-layout>
        </v-card>
      </v-layout>
    </v-container>
  </v-app>
</template>

<script>
import SignInCompo from '@/components/FirstPage/SignInCompo'
export default {
  name: 'VuetifySliderLogin',
  components: {
    SignInCompo
  },
  data () {
    return {
      model: 0,
      colors: [
        'primary',
        'secondary'
      ]
    }
  }
}
</script>
