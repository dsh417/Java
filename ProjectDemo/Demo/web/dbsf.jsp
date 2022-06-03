<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/15
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<img src="png/qljs01.png" alt="..">

</body>
<script>
    /**
     * 按宽高比例对图片进行等比缩放
     *
     * @param { HTMLCollection } imgObj 需要缩放的图片源对象
     *
     * @param { Number } scaleW 指定缩放的宽
     *
     * @param { Number } scaleH 指定缩放的高
     *
     */

    function resizeImage(imgObj, scaleW, scaleH) {
        // 创建 Image 对象。
        const image = new Image();
        //设置原图片 URL，用于获取原图片的真实宽高，即使 <img> 标签设定了宽、高，也不受影响。
        image.src = imgObj.src;

        let tempW; // 存储图片的宽高。
        let tempH;

        // onload 事件确保图片加载完成，否则获取的宽高会为 0
        image.onload = function () {
            // 原图片宽高比例 >= 指定缩放的宽高比例，则说明原图片：宽 >= 高。
            if (image.width / image.height >= scaleW / scaleH) {
                // 用原图片的宽高比例和指定的宽，求实际指定的高。
                if (image.width > scaleW) {
                    tempW = scaleW;
                    tempH = (image.height * scaleW) / image.width;
                } else {
                    // 按原图片的大小进行缩放。
                    tempW = image.width;
                    tempH = image.height;
                }
            } else {
                // 原图片：高 > 宽
                if (image.height > scaleH) {
                    // 用原图片的宽高比例和指定的高，求实际指定的宽。
                    tempH = scaleH;
                    tempW = (image.width * scaleH) / image.height;
                } else {
                    // 按原图片的大小进行缩放。
                    tempW = image.width;
                    tempH = image.height;
                }
            }
            // 设置图片的宽高
            imgObj.width = tempW;
            imgObj.height = tempH;
        };
    }

    // 调用
    const ele = document.getElementById('img'); // 获取img元素的方法有多种，这里仅是做演示

    resizeImage(ele, 400, 340);

</script>
</html>
