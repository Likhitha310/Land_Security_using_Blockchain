pragma solidity >0.5.0;
import './User.sol';

contract Transactions is User {
  
    //Land History
    struct landHistory{
        uint32 fromId;
        uint32 toId;
        string Date;
    }
    
    mapping(uint256=>landHistory[]) history;
    
    //get history
    //Get Length of blocks
    function getlength(uint256 _id) public view returns (uint) {
        return history[_id].length;
    }
    
    //get single block at a time
    function getTransactionHistorybyId(uint256 _landId,uint i)public view returns(uint32,uint32 ,string memory){
        uint32 fromId=history[_landId][i].fromId;
        uint32 toId=history[_landId][i].toId;
        string memory Date=history[_landId][i].Date;
        return(fromId,toId,Date);
    }
}
