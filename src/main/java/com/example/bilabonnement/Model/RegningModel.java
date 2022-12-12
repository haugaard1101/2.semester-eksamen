package com.example.bilabonnement.Model;

import com.example.bilabonnement.Repositories.SkadeRepository;

// Marcus
public class RegningModel {

    SkadeRepository skadeRepository = new SkadeRepository();

    private int kmVedIndlevering;
    private int kmVedAflevering;
    private int aftaleKM;
    private int kmRegning;
    private int skadeRegning;

 // Marcus
    public RegningModel(int kmVedIndlevering, int kmVedAflevering, int aftaleKM, int kmRegning, int skadeRegning) {
        //this.kmVedIndlevering = skadeRepository.findEnLejekontrakt();
        this.kmVedAflevering = kmVedAflevering;
        this.aftaleKM = aftaleKM;
        this.kmRegning = kmRegning;
        this.skadeRegning = skadeRegning;
    }

    public int getKmVedIndlevering() {
        return kmVedIndlevering;
    }

    public void setKmVedIndlevering(int kmVedIndlevering) {
        this.kmVedIndlevering = kmVedIndlevering;
    }

    public int getKmVedAflevering() {
        return kmVedAflevering;
    }

    public void setKmVedAflevering(int kmVedAflevering) {
        this.kmVedAflevering = kmVedAflevering;
    }

    public int getAftaleKM() {
        return aftaleKM;
    }

    public void setAftaleKM(int aftaleKM) {
        this.aftaleKM = aftaleKM;
    }

    public int getKmRegning() {
        return kmRegning;
    }

    public void setKmRegning(int kmRegning) {
        this.kmRegning = kmRegning;
    }

    public int getSkadeRegning() {
        return skadeRegning;
    }

    public void setSkadeRegning(int skadeRegning) {
        this.skadeRegning = skadeRegning;
    }

    @Override
    public String toString() {
        return "RegningModel{" +
                "kmVedIndlevering=" + kmVedIndlevering +
                ", kmVedAflevering=" + kmVedAflevering +
                ", aftaleKM=" + aftaleKM +
                ", kmRegning=" + kmRegning +
                ", skadeRegning=" + skadeRegning +
                '}';
    }
}
