const stripe = Stripe('pk_test_51PjyCdFLpE2V9zDDHdMXUkPbM8cWgVkvVjC3scDbuFE1nQVWoLKHczTPgB7dLPjqThunLj8Jc3fWRNfJ6ecV5WoM00RB4SDH6u');
 const paymentButton = document.querySelector('#paymentButton');
 
 paymentButton.addEventListener('click', () => {
   stripe.redirectToCheckout({
     sessionId: sessionId
   })
 });
 