package Strategy.payport;

public abstract class Payment {
    /*
    * 支付规范，支付逻辑
    *
    * */
//    支付类型
    public abstract String getName();
//    查询余额
    protected abstract double queryBalance(String uid);

//    扣款支付
    public AliPay pay(String uid, double amount){
        if(queryBalance(uid)<amount){
            return new AliPay(500,"支付失败","余额不足");
        }
        return new AliPay(200,"支付成功",amount);
    }
}
