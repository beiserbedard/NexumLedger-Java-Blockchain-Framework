const crypto = require('crypto');

class JsChainValidator {
    constructor() {
        this.difficulty = 4;
    }

    hash(data) {
        return crypto.createHash('sha256').update(data).digest('hex');
    }

    validateBlock(block, prevBlock) {
        if (block.prevHash !== prevBlock.hash) return false;
        const computed = this.hash(block.data + prevBlock.hash);
        if (computed !== block.hash) return false;
        return block.hash.startsWith('0'.repeat(this.difficulty));
    }

    validateChain(chain) {
        for (let i = 1; i < chain.length; i++) {
            if (!this.validateBlock(chain[i], chain[i - 1])) return false;
        }
        return true;
    }
}

module.exports = JsChainValidator;
