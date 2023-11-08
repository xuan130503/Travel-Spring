
var TrandingSlider = new Swiper('.tranding-slider', {
    effect: 'coverflow',
    grabCursor: true,
    centeredSlides: true,
    loop: false,
    slidesPerView: "auto",
    coverflowEffect: {
      rotate: 0,
      stretch: 0,
      depth: 100,
      modifier: 2.5,
    },
    pagination: {
      el: '.swiper-pagination',
      clickable: true,
    },
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    }
  });
function changeBackground(imageUrl) {
    var sliderContainer = document.getElementById('slider-container');
    sliderContainer.style.opacity = 0; // Đặt opacity thành 0
    setTimeout(function () {
        sliderContainer.style.backgroundImage = 'url(' + imageUrl + ')';
        sliderContainer.style.opacity = 1; // Đặt opacity thành 1
    }, 10); 
}
document.querySelector('.swiper-button-next').addEventListener('click', function () {
    var activeSlide = TrandingSlider.slides[TrandingSlider.activeIndex];
    var imageUrl = activeSlide.querySelector('img').getAttribute('src');
    var sliderContainer = document.getElementById('slider-container');
    sliderContainer.style.backgroundImage = 'url(' + imageUrl + ')';
    changeBackground(imageUrl);
    updateContent(TrandingSlider.activeIndex);
});

document.querySelector('.swiper-button-prev').addEventListener('click', function () {
    var activeSlide = TrandingSlider.slides[TrandingSlider.activeIndex];
    var imageUrl = activeSlide.querySelector('img').getAttribute('src');
    var sliderContainer = document.getElementById('slider-container');
    sliderContainer.style.backgroundImage = 'url(' + imageUrl + ')';
    changeBackground(imageUrl);
    updateContent(TrandingSlider.activeIndex);
});

TrandingSlider.on('transitionEnd', function () {
    var activeSlide = TrandingSlider.slides[TrandingSlider.activeIndex];
    var imageUrl = activeSlide.querySelector('img').getAttribute('src');
    var sliderContainer = document.getElementById('slider-container');
    sliderContainer.style.backgroundImage = 'url(' + imageUrl + ')';
    changeBackground(imageUrl);
    updateContent(TrandingSlider.activeIndex);
});

var schedulesData = [[${schedules}]];
/*var sliderContents = [
  {
      title: "Slide 1 Title",
      description: "Lorem",
  },
  {
      title: "Slide 2 Title",
      description: "Slide 2 Description",
  },
  {
      title: "Slide 3 Title",
      description: "Slide 3 Description",
  },
  {
    title: "Slide 4 Title",
    description: "Slide 4 Description",
  },
  {
    title: "Slide 5 Title",
    description: "Slide 5 Description",
  },
  {
    title: "Slide 6 Title",
    description: "Slide 6 Description",
  },
  {
    title: "Slide 7 Title",
    description: "Slide 7 Description",
  },
];
function updateContent() {
  // var activeSlide = TrandingSlider.slides[TrandingSlider.activeIndex];
  var activeSlideIndex = TrandingSlider.activeIndex;
  var col4Content = document.querySelector('.slide-content');
  col4Content.querySelector('.slide-title').textContent = sliderContents[activeSlideIndex].title;
  col4Content.querySelector('.slide-description').textContent = sliderContents[activeSlideIndex].description;
}*/
function updateContent(activeSlideIndex) {
  var slideContent = document.querySelectorAll('.slide-content');
  var currentSlideData = schedulesData[activeSlideIndex];
  
  slideContent.forEach(function (element, index) {
      var slideTitle = element.querySelector('.slide-title');
      var slideDescription = element.querySelector('.slide-description');
      
      if (index === activeSlideIndex) {
          slideTitle.textContent = currentSlideData.title;
          slideDescription.textContent = currentSlideData.description;
      }
  });
}


// Rest API 
// var sliderContents = [];
// fetch('/api/slider-data') 
//     .then(response => response.json())
//     .then(data => {
        
//         sliderContents = data; 
//         updateCol4Content();
//     })
//     .catch(error => {
//         console.error('Lỗi khi lấy dữ liệu từ API: ', error);
//     });

// function updateCol4Content() {
//     var activeSlide = TrandingSlider.slides[TrandingSlider.activeIndex];
//     var activeSlideIndex = TrandingSlider.activeIndex;
//     var col4Content = document.querySelector('.col-4-content');
//     col4Content.querySelector('.slide-title').textContent = sliderContents[activeSlideIndex].title;
//     col4Content.querySelector('.slide-description').textContent = sliderContents[activeSlideIndex].description;
// }