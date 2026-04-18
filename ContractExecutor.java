package chain.contract;

import java.util.Map;

public interface ContractExecutor {
    Object execute(Map<String, Object> params);
}
