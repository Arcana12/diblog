<script setup lang="ts">
import {onMounted, ref} from "vue";
import axios from "axios";
import {useRouter} from "vue-router";

const props = defineProps({
    postId: {
        type: [Number, String],
        require: true
    }
});


const post = ref({
    id: 0,
    title: "",
    content: ""
});

onMounted(() => {
    axios.get(`/api/posts/${props.postId}`).then(response => {
        post.value = response.data;
    })
})

const router = useRouter();

const moveToEdit = () => {
    router.push({name: "edit", params: {postId: props.postId}})
}

const postDelete = function (){
    axios.delete(`/api/posts/${props.postId}`)
        .then(() => {
            router.replace({name: "home"})
        })
}

</script>

<template>

    <el-row justify="center">
        <el-col :span="16">
            <el-row>
                <el-col>
                    <div class="category">
                        Study / Spring
                    </div>
                    <h1 class="title">{{ post.title }}</h1>
                    <time class="regDate">
                        2023-04-28
                    </time>
                </el-col>
            </el-row>

            <el-row>
                <el-col>
                    <div class="content">{{ post.content }}</div>
                </el-col>
            </el-row>
            <el-row>
                <el-col>
                    <div class="d-flex justify-content-end">
                        <el-button type="warning" @click="moveToEdit()">수정</el-button>
                        <el-button type="danger" @click="postDelete()">삭제</el-button>
                    </div>
                </el-col>
            </el-row>

        </el-col>
    </el-row>

</template>

<style scoped lang="scss">
.title {
  font-size: 30px;
  color: #1E1F21;
}

.content {
  margin-top: 40px;
  margin-bottom: 40px;
  color: #353638;
  white-space: break-spaces;
}

.category {
  margin-top: 4px;
  font-size: 14px;
}

.regDate {
  font-size: 14px;
  color: #9999A1;
}


</style>