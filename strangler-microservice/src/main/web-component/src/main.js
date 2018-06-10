import Vue from 'vue'
import StranglerMessageComponent from './StranglerMessageComponent.vue'
import StranglerGreetingComponent from './StranglerGreetingComponent.vue'

Vue.config.productionTip = false

const messageComponent = document.querySelector('#strangler-message-component')
if (messageComponent) {
  new Vue({
    el: messageComponent,
    render: h => h(StranglerMessageComponent, {
      props: { ...messageComponent.dataset }
    })
  })
}

const greetingComponent = document.querySelector('#strangler-greeting-component')
if (greetingComponent) {
  new Vue({
    el: greetingComponent,
    render: h => h(StranglerGreetingComponent, {
      props: { ...greetingComponent.dataset }
    })
  })
}
