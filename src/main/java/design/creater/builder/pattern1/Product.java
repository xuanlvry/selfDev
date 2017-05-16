package design.creater.builder.pattern1;

/**
 * 产品类
 * @author Chengfei.Sun on 2016/10/17.
 */
public class Product {
    private String name;

    private String body;

    private String head;

    private String leftArm;

    private String leftHand;

    private String rightArm;

    private String rightHand;

    private String leftFoot;

    private String leftLeg;

    private String rightFoot;

    private String rightLeg;

    public Product(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getLeftArm() {
        return leftArm;
    }

    public void setLeftArm(String leftArm) {
        this.leftArm = leftArm;
    }

    public String getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(String leftHand) {
        this.leftHand = leftHand;
    }

    public String getRightArm() {
        return rightArm;
    }

    public void setRightArm(String rightArm) {
        this.rightArm = rightArm;
    }

    public String getRightHand() {
        return rightHand;
    }

    public void setRightHand(String rightHand) {
        this.rightHand = rightHand;
    }

    public String getLeftFoot() {
        return leftFoot;
    }

    public void setLeftFoot(String leftFoot) {
        this.leftFoot = leftFoot;
    }

    public String getLeftLeg() {
        return leftLeg;
    }

    public void setLeftLeg(String leftLeg) {
        this.leftLeg = leftLeg;
    }

    public String getRightFoot() {
        return rightFoot;
    }

    public void setRightFoot(String rightFoot) {
        this.rightFoot = rightFoot;
    }

    public String getRightLeg() {
        return rightLeg;
    }

    public void setRightLeg(String rightLeg) {
        this.rightLeg = rightLeg;
    }
}
