package main

import "fmt"

type BlockchainNode struct {
	NodeID  string
	Port    int
	Version string
}

func NewBlockchainNode(port int) *BlockchainNode {
	return &BlockchainNode{
		NodeID:  fmt.Sprintf("GO_NODE_%d", port),
		Port:    port,
		Version: "GO_CHAIN_V1",
	}
}

func (n *BlockchainNode) Start() {
	fmt.Printf("Go P2P Node started on port %d\n", n.Port)
}

func (n *BlockchainNode) Status() string {
	return fmt.Sprintf("Node=%s, Active=true", n.NodeID)
}

func main() {
	node := NewBlockchainNode(9000)
	node.Start()
	fmt.Println(node.Status())
}
