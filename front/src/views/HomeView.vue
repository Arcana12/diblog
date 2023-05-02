<script setup lang="ts">
import axios from "axios";
import {ref} from "vue";
import {useRouter} from "vue-router";

const props = defineProps({
    page: {
        type: [Number, String],
        require: true
    }
});

const posts = ref([]);
const router = useRouter();
const totalCount = ref();
const pageSize = ref();
const currentPage = ref();


axios.get("/api/posts").then(response => {
    response.data.postResponseList.forEach((r: any) => {
        posts.value.push(r);
    })
    totalCount.value = response.data.count;
    pageSize.value = response.data.size;
    currentPage.value = response.data.page;
})

function movePage(page: number){
    axios.get(`/api/posts?page=${page}`).then(response => {
        posts.value = response.data.postResponseList;
        totalCount.value = response.data.count;
        pageSize.value = response.data.size;
        currentPage.value = response.data.page;
    })
}


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

            <div class="paging">
                <el-pagination :hide-on-single-page="false"
                               background
                               layout="prev, pager, next"
                               :page-size="pageSize"
                               v-model:current-page="currentPage"
                               :total="totalCount"
                               @current-change = "movePage"
                />
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

  .paging {
    align-items: center;
  }
}

</style>