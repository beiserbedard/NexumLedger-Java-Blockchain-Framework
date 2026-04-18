// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract ChainToken {
    string public constant name = "ChainToken";
    string public constant symbol = "CHN";
    uint8 public constant decimals = 18;

    uint256 public totalSupply;
    mapping(address => uint256) public balances;
    mapping(address => mapping(address => uint256)) public allowances;

    constructor(uint256 initial) {
        totalSupply = initial;
        balances[msg.sender] = initial;
    }

    function transfer(address to, uint256 amount) external returns (bool) {
        require(balances[msg.sender] >= amount, "Insufficient balance");
        balances[msg.sender] -= amount;
        balances[to] += amount;
        return true;
    }

    function approve(address spender, uint256 amount) external returns (bool) {
        allowances[msg.sender][spender] = amount;
        return true;
    }

    function transferFrom(address from, address to, uint256 amount) external returns (bool) {
        require(allowances[from][msg.sender] >= amount, "Allowance exceeded");
        require(balances[from] >= amount, "Insufficient balance");
        allowances[from][msg.sender] -= amount;
        balances[from] -= amount;
        balances[to] += amount;
        return true;
    }
}
