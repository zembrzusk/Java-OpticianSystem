package com.system;

public class Lenses {

    private int lensesId;
    public int getLensesId() {return lensesId;}
    public void setLensesId(int lensesId) {
        this.lensesId = lensesId;
    }

    private float price;
    private static int minPrice = 1;
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        if (price<minPrice) {throw new IllegalArgumentException("Price can not be smaller than " + minPrice + ".");}
        this.price = price;
    }
    public static void setMinPrice(int minPrice) {
        if (minPrice < 0) {throw new IllegalArgumentException("Price can not be smaller than 0.");}
        Lenses.minPrice = minPrice;
    }

    private double leftLens, rightLens;
    public double getLeftLens() {return leftLens;}
    public double getRightLens() {return rightLens;}
    public void setLeftLens(double value) {
        setLensValue(value, 0);
    }
    public void setRightLens(double value) {
        setLensValue(value, 1);
    }
    private void setLensValue(double value, int lens) {
        if (value >  10) {throw new IllegalArgumentException("Wrong lens value.");}
        if (value < -10) {throw new IllegalArgumentException("Wrong lens value.");}

        if(lens == 0) {this.leftLens = value;}
        if(lens == 1) {this.rightLens = value;}
    }

    private LensesStatus status;
    public LensesStatus getStatus() {
        return status;
    }
    public void setStatus(LensesStatus status) {
        this.status = status;
    }

    private LensesType type;
    public LensesType getType() {
        return type;
    }
    public void setType(LensesType type) {
        this.type = type;
    }

    //ASSOCIATION
    private Glasses glasses;
    public Glasses getGlasses() {return glasses;}
    public void setGlasses(Glasses glasses) {
        this.glasses = glasses;
        if(glasses.getLenses()!=this) {
            glasses.setLenses(this);
        }
    }

    //constructors
    Lenses(int lensesId, LensesType type, float price) {
        setLensesId(lensesId);
        setType(type);
        setPrice(price);

        setLeftLens(0); setRightLens(0);
        setStatus(LensesStatus.TODO);
    }

    Lenses(int lensesId, LensesType type, float price, double leftLens, double rightLens) {
        setLensesId(lensesId);
        setType(type);
        setPrice(price);
        setLeftLens(leftLens); setRightLens(rightLens);

        setStatus(LensesStatus.TODO);
    }
}
enum LensesStatus {TODO, IN_PROGRESS, DONE}
enum LensesType {SUN, CLEAR, BLUE, GREEN, ORANGE}
