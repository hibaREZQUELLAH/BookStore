const indicator = document.getElementById("indicator");

/* ========== Products Slider =========== */
const productSwiper = new Swiper(".product-swiper", {
  grabCursor: true,
  slidesPerView: 1,
  spaceBetween: 30,
  watchOverflow: true,
  navigation: {
    nextEl: ".custom-next",
    prevEl: ".custom-prev",
    lockClass: "no",
  },
  breakpoints: {
    900: {
      slidesPerView: 2,
    },
  },
});

/* ========== Filter Products =========== */
const filters = [...document.querySelectorAll(".filters .linkGet")];
filters.forEach((filter) => {
  filter.addEventListener("click", (e) => {
    let target = e.target;
    if (!target) return;
    filters.forEach((btn) => {
      btn.classList.remove("active");
    });
    target.classList.add("active");    
  });
})
