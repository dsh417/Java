package disign.Adapter.Simple;

public class PowerAdapter implements DC5{

    private AC220 ac220;
    public PowerAdapter(AC220 ac220){
        this.ac220=ac220;
    }

    @Override
    public int outputDC5V() {
        int adapterInput=ac220.outputAC220();
        int adapterOutput=adapterInput/44;
        System.out.println(adapterOutput);
        return adapterOutput;
    }
}
