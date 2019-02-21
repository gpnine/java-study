let remFn = function () {
    let fontSize;
    fontSize = (window.screen.width / 1280) * 100;
    document.querySelector('html').style.fontSize = fontSize + 'px';
};
remFn();
window.onresize = function () {
    remFn();
};
var videoElement = document.getElementById("video");
var title = document.querySelector('.title');
function setVideo(url,name){
    title.innerText = name;
    var videobox = '';
    videobox += '<video webkit-playsinline="true" autoplay="autoplay" playsinline="true" x-webkit-airplay="true" x5-video-player-type="h5"' +
        'x5-video-player-fullscreen="true" x5-video-ignore-metadata="true" class="oneVideo" poster="./img/cover.png"' +
        'src="' + url + '" controls="controls"></video>';
    videoElement.innerHTML = videobox;
}
function getVideoUrl(src, name, index) {
    var listLine = document.querySelector('.list-content').childNodes;
    for (var i = 0; i < listLine.length; i++) {
        listLine[i].style.color = '';
    }
    var clickVideo = document.querySelector('[data-id="' + index + '"]');
    clickVideo.style.color = '#f19238';
    setVideo(src,name);
}
window.onload = function () {
    var discBtn = document.querySelector('.video-disc');
    var listBtn = document.querySelector('.video-list');
    var discBoard = document.querySelector('.disc-board');
    var listBoard = document.querySelector('.list-board');
    var list = document.querySelector('.list-content');
    // var baseUrl = "http://localhost:8088/api";
    var baseUrl = "http://learn.mediation.homolo.net/api";
    var url = baseUrl + "/course/lectureHalls";
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200 || xhr.status == 304) {
            var json = JSON.parse(xhr.responseText);
            var array = json.result;
            var str = '';
            var firstElement = array[0];
            var firstName = firstElement.properties.name;
            var firstUrl = firstElement.expend.url.LD;
            setVideo(firstUrl,firstName);
            for (var i = 0; i < array.length; i++) {
                var e = array[i];
                var name = e.properties.name;
                var url = e.expend.url.LD;
                if(i==0){
                    str += '<li class="list-line" style="color: rgb(241, 146, 56);" data-id="' + (i + 1) + '"><div onclick="getVideoUrl(\'' + url + '\',\'' + name + '\',' + (i + 1) + ')" class="list-name">' + name +
                        '</div></li>';
                }else{
                    str += '<li class="list-line" data-id="' + (i + 1) + '"><div onclick="getVideoUrl(\'' + url + '\',\'' + name + '\',' + (i + 1) + ')" class="list-name">' + name +
                        '</div></li>';
                }
            }
            list.innerHTML = str;
        }
    };
    xhr.send();

    discBtn.addEventListener('click', function () {
        var flag = true;
        this.classList.forEach(e => {
            if (e === 'active') {
            flag = false;
        }
    });
        if (flag) {
            discBoard.style.display = 'block';
            listBoard.style.display = 'none';
            this.classList.add('active');
            listBtn.classList.remove('active');
        } else {
            discBoard.style.display = 'none';
            this.classList.remove('active');
        }
    });
    listBtn.addEventListener('click', function () {
        var flag = true;
        this.classList.forEach(e => {
            if (e === 'active') {
            flag = false;
        }
    });
        if (flag) {
            listBoard.style.display = 'block';
            discBoard.style.display = 'none';
            this.classList.add('active');
            discBtn.classList.remove('active');
        } else {
            listBoard.style.display = 'none';
            this.classList.remove('active');
        }
    });
    // list.addEventListener('click', function (e) {
    //   debugger
    //   var el = e.target
    //   while (el.tagName !== 'LI') {
    //     if (el === list) {
    //       el = null
    //       break;
    //     }
    //     el = el.parentNode
    //   }
    //   if (el) {
    //     console.log(el.dataset.id);
    //   }
    // })
};