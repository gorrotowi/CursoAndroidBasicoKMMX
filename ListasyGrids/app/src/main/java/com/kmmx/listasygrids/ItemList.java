package com.kmmx.listasygrids;

/**
 * Created by Gorro on 01/10/16.
 */

public class ItemList {

    String titulo, subtitulo, imgUrl;
    int img;

    public ItemList(String titulo, String subtitulo, int img) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.img = img;
    }

    public ItemList(String titulo, String subtitulo, String imgUrl) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.imgUrl = imgUrl;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
