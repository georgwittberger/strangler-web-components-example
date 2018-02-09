import Vue from 'vue';
import StranglerMessageComponent from './StranglerMessageComponent';
import StranglerGreetingComponent from './StranglerGreetingComponent';

Vue.config.productionTip = false;

// Create the message component
const messageElement = document.querySelector('#strangler-message-component');
if (messageElement) {
  /* eslint-disable no-new */
  new Vue({
    el: messageElement,
    render: h => h(StranglerMessageComponent, {
      props: {
        serverBaseUrl: messageElement.dataset.serverBaseUrl,
      },
    }),
  });
}

// Create the greeting component
const greetingElement = document.querySelector('#strangler-greeting-component');
if (greetingElement) {
  /* eslint-disable no-new */
  new Vue({
    el: greetingElement,
    render: h => h(StranglerGreetingComponent, {
      props: {
        serverBaseUrl: greetingElement.dataset.serverBaseUrl,
        monolithSessionCookieName: greetingElement.dataset.monolithSessionCookieName,
        monolithSessionCookieValue: greetingElement.dataset.monolithSessionCookieValue,
      },
    }),
  });
}
