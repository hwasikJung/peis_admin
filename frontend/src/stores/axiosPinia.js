import { defineStore } from 'pinia';

export const useAxiosPiniaStore = defineStore('axiosPinia', {
  state: () => ({
    data: null,
  }),

  actions: {
    async fetchData(api) {
      try {
        const response = await api.get('news/1.json');
        this.data = response.data;
      } catch (error) {
        console.error('데이터를 가져오는 중 에러 발생:', error);
        throw error; // 에러를 다시 던져서 컴포넌트에서 처리하도록 합니다
      }
    },
  },
});
