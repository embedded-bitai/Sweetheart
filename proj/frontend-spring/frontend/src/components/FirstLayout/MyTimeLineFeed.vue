<template>
  <v-layout column style="margin-top: 10px; width: 700px">
    <v-flex>
      <v-card style="width: 100%; margin-bottom: 10px">
        <v-layout>
          <v-flex>
            <v-expansion-panels
              flat
            >
              <v-expansion-panel style="margin-bottom: 10px">
                <v-expansion-panel-header hide-actions>
                  <v-layout column>
                    <v-layout style="margin: 0 20px 10px 0">
                      <v-flex style="text-align: start" >
                        <v-btn disabled depressed style="background-color: rgba(255,255,255,0.0); align-content: start">
                          <v-img
                            v-if="userImg"
                            src="https://cdn.vuetifyjs.com/images/john.jpg"
                            width="25px"
                          ></v-img>
                          <v-img
                            v-else
                            :src=this.userDefaultImg
                            max-width="30px"
                          ></v-img>
                          <span class="black--text" v-for="(contents, idx) in timelinePost" :key="idx">
                            <h6>{{ contents.regDate }}</h6>
                            <h3 align="left" class="ml-3">{{ contents.userName }}</h3>
                          </span>
                        </v-btn>
                      </v-flex>
                      <v-flex style="margin: 10px; text-align: end">
                        <v-dialog
                          v-model="dialog"
                          max-width="400"
                        >
                          <template v-slot:activator="{ on, attrs }">
                            <v-btn
                              style="background-color: rgba(255,255,255,0.0)"
                              depressed
                              fab
                              small
                              v-bind="attrs"
                              v-on="on"
                            >
                              <v-icon>mdi-dots-vertical</v-icon>
                            </v-btn>
                          </template>
                          <v-card>
                            <v-card-text align="center">
                              동의 하시면 이 피드를 다시볼수 없습니다. <br>
                              동의 하십니까?
                            </v-card-text>
                            <v-divider></v-divider>
                            <v-card-actions>
                              <v-btn
                                color="green darken-1"
                                text
                                @click="dialog = false"
                              >
                                Disagree
                              </v-btn>
                              <v-spacer/>
                              <v-btn
                                color="primary"
                                text
                                @click="dialog = false"
                              >
                                Agree
                              </v-btn>
                            </v-card-actions>
                          </v-card>
                        </v-dialog>
                      </v-flex>
                    </v-layout>
                    <v-layout column v-for="(contents, idx) in timelinePost" :key="idx">
                      <v-flex>
                        <v-img
                          v-if="timelinePost.image"
                          src="https://cdn.vuetifyjs.com/images/john.jpg"
                          style="width: 100%" height="250px"
                        />
                      </v-flex>
                      <v-flex>
                        <v-card-text style="width: 100%">
                          {{ contents.content }}
                        </v-card-text>
                        <v-flex>
                          <v-btn icon style="margin-right: 10px"><span>Like</span></v-btn>
                          <v-btn icon><span>Post</span></v-btn>
                        </v-flex>
                      </v-flex>
                    </v-layout>
                  </v-layout>
                </v-expansion-panel-header>
                <v-expansion-panel-content>
                  <v-layout column>
                    <v-flex>
                      <v-textarea
                        rows="1"
                        placeholder="Please leave a message."
                      ></v-textarea>
                    </v-flex>
                    <v-felx>
                      <li>
                        <v-img src="https://cdn.vuetifyjs.com/images/john.jpg " style="width: 50px"></v-img><span>그냥 쓸께 없어요요요요요요요</span>
                      </li>
                      <li>
                        <v-img src="https://cdn.vuetifyjs.com/images/john.jpg " style="width: 50px"></v-img><span>뭐라도 적어야지.</span>
                      </li>
                    </v-felx>
                  </v-layout>
                </v-expansion-panel-content>
              </v-expansion-panel>
            </v-expansion-panels>
          </v-flex>
        </v-layout>
      </v-card>
    </v-flex>
  </v-layout>
</template>

<script>
import axios from 'axios'

export default {
  data () {
    return {
      dialog: false,
      userName: this.$store.state.myProfile[0].userName,
      userImg: '',
      userDefaultImg: require('../../assets/blank-profile-picture-973460_1280.png'),
      regDate: '',
      content: '',
      timelinePost: []
    }
  },
  created () {
    axios.get('http://localhost:7777/timeline/list/all/')
      .then(res => {
        console.log('get timeline post')
        this.timelinePost = res.data
      })
      .catch(err => {
        console.log('created()' + err.response)
      })
  }
}
</script>
