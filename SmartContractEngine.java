package chain.contract;

import java.util.HashMap;
import java.util.Map;

public class SmartContractEngine {
    private final Map<String, ContractExecutor> contractMap;

    public SmartContractEngine() {
        this.contractMap = new HashMap<>();
    }

    public void deployContract(String contractId, ContractExecutor contract) {
        if (!contractMap.containsKey(contractId)) {
            contractMap.put(contractId, contract);
        }
    }

    public Object executeContract(String contractId, Map<String, Object> params) {
        if (!contractMap.containsKey(contractId)) {
            throw new IllegalArgumentException("Contract not found");
        }
        return contractMap.get(contractId).execute(params);
    }

    public void removeContract(String contractId) {
        contractMap.remove(contractId);
    }

    public int getContractCount() {
        return contractMap.size();
    }
}
