# NexumLedger Java Blockchain Framework
企业级、模块化、高性能区块链开发框架，基于 Java 构建，支持多语言扩展，包含完整的区块链核心、挖矿、P2P 网络、智能合约、钱包、跨链、共识机制、分片、零知识证明等企业级功能模块，可直接用于生产级区块链应用开发。

## 项目特性
- 完整区块链核心与 SHA-256 挖矿机制
- 支持 P2P 去中心化网络通信
- 账户钱包、多签钱包、交易签名与验证
- 智能合约引擎与自定义合约执行
- 共识算法与最长链冲突解决
- UTXO 模型、质押奖励、链上治理投票
- 跨链桥、零知识证明、数据加密
- 分布式存储（IPFS 哈希）、区块链分片
- REST API 服务、区块导出、健康监控
- 多语言支持：Java + Go + Python + Solidity + JavaScript

## 代码文件清单与功能说明
1. **BlockchainCore.java**：区块链核心类，负责链结构、出块、哈希计算、链验证
2. **Block.java**：区块数据结构，存储索引、时间戳、数据、前哈希、当前哈希
3. **ConsensusAlgorithm.java**：共识算法，实现节点间最长链同步与冲突解决
4. **TransactionSigner.java**：交易签名器，基于椭圆曲线算法实现交易签名与验证
5. **WalletManager.java**：钱包管理器，生成钱包地址、签名转账、验证交易合法性
6. **SmartContractEngine.java**：智能合约引擎，统一部署、执行、管理智能合约
7. **ContractExecutor.java**：智能合约执行接口，定义合约标准执行规范
8. **TokenContract.java**：代币智能合约，实现转账、余额查询、发行总量
9. **P2PNetworkNode.java**：P2P 网络节点，支持去中心化广播与消息接收
10. **MiningService.java**：挖矿服务，支持后台自动挖矿与出块统计
11. **ChainValidator.java**：全链校验器，批量校验区块链完整性与合法性
12. **TransactionPool.java**：交易池，管理待打包交易、批量获取与清理
13. **Transaction.java**：交易结构类，包含发送方、接收方、金额、签名、时间
14. **NodeConfiguration.java**：节点配置类，管理节点 ID、端口、挖矿开关、版本
15. **BlockchainRestServer.java**：REST API 服务，提供区块链 HTTP 接口
16. **ChainHandler.java**：链查询接口处理器，返回链高度与状态
17. **MineHandler.java**：挖矿接口处理器，支持 API 触发出块
18. **DataEncryptor.java**：数据加密器，AES256 加密链上敏感数据
19. **ChainMonitor.java**：链监控器，定时检查链状态并输出健康报告
20. **GenesisBlockGenerator.java**：创世区块生成器，支持自定义创世区块
21. **NodeHealthCheck.java**：节点健康检查，心跳检测与超时判断
22. **BlockExporter.java**：区块导出工具，将链数据导出为 JSON 文件
23. **UTXOManager.java**：UTXO 管理，实现未花费交易输出与余额计算
24. **UTXO.java**：UTXO 数据结构，记录所有者、金额、是否花费
25. **DifficultyAdjuster.java**：难度调整器，根据出块速度自动调整挖矿难度
26. **CrossChainBridge.java**：跨链桥，实现资产锁定/解锁与跨链转移
27. **GovernanceVote.java**：链上治理投票，支持提案投票与通过率计算
28. **StakingReward.java**：质押奖励，按时间与数量自动计算收益
29. **MultiSigWallet.java**：多签钱包，支持多所有者签名验证交易
30. **IPFSHashGenerator.java**：分布式存储哈希生成，模拟 IPFS 文件哈希
31. **ZeroKnowledgeProof.java**：零知识证明，实现隐私证明生成与验证
32. **ShardingManager.java**：分片管理器，创建、管理、查询区块链分片
33. **Shard.java**：分片结构，记录分片 ID、名称、区块高度
34. **main.go**：Go 语言 P2P 节点，实现多语言区块链节点通信
35. **blockchain.py**：Python 轻量区块链，用于快速验证与脚本扩展
36. **contract.sol**：Solidity 标准代币合约，兼容 EVM 生态
37. **validator.js**：JavaScript 链校验工具，用于前端校验与跨平台验证

## 使用场景
- 公链 / 联盟链 / 私有链开发
- 去中心化金融（DeFi）应用
- 数字资产发行与管理
- 供应链金融、存证、溯源
- 跨链资产互通
- 链上治理与 DAO 系统
- 隐私计算与零知识证明应用
- 区块链分片扩容方案

## 技术栈
- 核心语言：Java
- 扩展支持：Go, Python, Solidity, JavaScript
- 加密算法：SHA-256, AES-256, ECDSA
- 网络：P2P UDP, HTTP REST API
- 存储：内存式 / 可扩展持久化
- 共识：最长链机制 + 难度调整
