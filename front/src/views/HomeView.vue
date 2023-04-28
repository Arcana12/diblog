<script setup lang="ts">
import axios from "axios";
import {ref} from "vue";
import {useRouter} from "vue-router";

const posts = ref([]);
const router = useRouter();

axios.get("/api/posts?page=1&size=5").then(response => {
    response.data.forEach((r: any) => {
        posts.value.push(r);
    })
})

</script>

<template>
    <el-row justify="center">
        <el-col :span="16">
            <div class="post" v-for="post in posts" :key="post.id">
                <div class="flex-column">
                    <div class="sub category">
                        Study / Spring
                    </div>
                    <h2 class="title">
                        <router-link :to="{ name: 'read', params: {postId : post.id}}">{{ post.title }}</router-link>
                    </h2>
                    <time class="regDate">
                        2023-04-28
                    </time>

                    <div class="content">
                        {{ post.content }}
                    </div>
                </div>

            </div>
        </el-col>
    </el-row>

</template>

<style scoped lang="scss">
.post {
  display: flex;
  height: 250px;
  align-items: center;

  .title {
    a {
      text-decoration: none;
      font-size: 24px;
      color: #1E1F21;
    }
  }

  .content {
    margin-top: 12px;
    color: #9999A1;
  }

  &:last-child {
    margin-bottom: 0;
  }

  .sub {
    margin-top: 4px;
    font-size: 14px;
  }

  .regDate {
    color: #9999A1;
  }
}

</style>