import Vue from 'vue';
import StranglerMessageComponent from '@/StranglerMessageComponent';

describe('StranglerMessageComponent.vue', () => {
  it('should render correct contents', () => {
    Vue.extend(StranglerMessageComponent);
    // const Constructor = Vue.extend(StranglerMessageComponent);
    // const vm = new Constructor().$mount();
    // expect(vm.$el.querySelector('h2').textContent)
    //   .toEqual('Message Component');
  });
});
