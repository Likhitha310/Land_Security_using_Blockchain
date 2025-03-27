//District and Taluka Dataset
var data=
{
'Ahmednagar ':
    ['Nagar', 'Shevgaon', 'Pathardi', 'Parner', 'Sangamner', 'Kopargaon', 'Akole', 'Shrirampur', 'Nevasa', 'Rahata', 'Rahuri', 'Shrigonda', 'Karjat', 'Jamkhed'],
'Akola ':
    ['Akola', 'Akot', 'Telhara', 'Balapur', 'Patur', 'Murtajapur', 'Barshitakli'],
'Amravati ':
    ['Amravati', 'Bhatukali', 'Nandgaon Khandeshwar', 'Dharni (Amravati)', 'Chikhaldara', 'Achalpur', 'Chandurbazar', 'Morshi', 'Warud', 'Daryapur', 'Anjangaon-Surji', 'Chandur', 'Dhamangaon', 'Tiosa'],
'Aurangabad ':
    ['Aurangabad', 'Kannad', 'Soegaon', 'Sillod', 'Phulambri', 'Khuldabad', 'Vaijapur', 'Gangapur', 'Paithan'],
'Beed ':
    ['Beed', 'Ashti', 'Patoda', 'Shirur-Kasar', 'Georai', 'Majalgaon', 'Wadwani', 'Kaij', 'Dharur', 'Parli', 'Ambejogai'],
'Bhandara ':
    ['Bhandara', 'Tumsar', 'Pauni', 'Mohadi', 'Sakoli', 'Lakhni', 'Lakhandur'],
'Buldhana ':
    ['Buldhana', 'Chikhli', 'Deulgaon', 'Jalgaon Jamod', 'Sangrampur', 'Malkapur', 'Motala', 'Nandura', 'Khamgaon', 'Shegaon', 'Mehkar', 'Sindkhed', 'Lonar'],
'Chandrapur ':
    ['Chandrapur', 'Saoli', 'Mul', 'Ballarpur', 'Pombhurna', 'Gondpimpri', 'Warora', 'Chimur', 'Bhadravati', 'Bramhapuri', 'Nagbhid', 'Sindewahi', 'Rajura', 'Korpana', 'Jivati'],
'Dhule ':
    ['Dhule ', 'Sakri', '', 'Shirpur'],
'Gadchiroli ':
    ['Gadchiroli', 'Dhanora', 'Chamorshi', 'Mulchera', 'Desaiganj (Vadasa)', 'Armori', 'Kurkheda', 'Korchi', 'Aheri', 'Bhamragad', 'Sironcha'],
'Gondia ':
    ['Gondia', 'Tirora', 'Goregaon', 'Arjuni Morgaon', 'Amgaon', 'Salekasa', 'Sadak Arjuni', 'Deori'],
'Hingoli ':
    ['Hingoli', 'Sengaon', 'Kalamnuri', 'Basmath', 'Aundha Nagnath'],
'Jalgaon ':
    ['Jalgaon ', 'Jamner', 'Erandol', 'Dharangaon', 'Bhusawal', 'Raver', 'Muktainagar (Edalabad)', 'Bodwad', 'Yawal', 'Amalner', 'Parola', 'Chopda', 'Pachora', 'Bhadgaon', 'Chalisgaon'],
'Jalna ':
    ['Jalna', 'Bhokardan', 'Jafrabad', 'Badnapur', 'Ambad', 'Ghansawangi', 'Partur', 'Mantha'],
'Kolhapur ':
    ['Karvir', 'Panhala', 'Shahuwadi', 'Kagal', 'Hatkanangale', 'Shirol', 'Radhanagari', 'Gaganbawada', 'Bhudargad', 'Gadhinglaj', 'Chandgad', 'Ajra'],
'Latur ':
    ['Latur', 'Renapur', 'Ahmedpur', 'Jalkot', 'Chakur', 'Shirur Anantpal', 'Ausa', 'Nilanga', 'Deoni', 'Udgir'],
'Mumbai City District':
    ['Mahad subdivision'],
'Mumbai Suburban District':
    ['Kurla (Mulund)', 'Andheri', 'Borivali'],
'Nagpur ':
    ['Nagpur (Urban)', 'Nagpur (Rural)', 'Kamptee', 'Hingna', 'Katol', 'Narkhed', 'Savner', 'Kalameshwar', 'Ramtek', 'Mouda', 'Parseoni', 'Umred', 'Kuhi', 'Bhiwapur'],
'Nanded ':
    ['Nanded', 'Ardhapur', 'Mudkhed', 'Bhokar', 'Umri', 'Loha', 'Kandhar', 'Kinwat', 'Himayatnagar', 'Hadgaon', 'Mahur', 'Deglur', 'Mukhed', 'Dharmabad', 'Biloli', 'Naigaon (Khairgaon)'],
'Nandurbar ':
    ['Nandurbar', 'Navapur', 'Shahada', 'Talode', 'Akkalkuwa', 'Akrani (Dhadgaon)'],
'Nashik District':
    ['Nashik', 'Igatpuri', 'Dindori', 'Peth', 'Trimbakeshwar', 'Kalwan', 'Deola', 'Surgana', 'Baglan (Satana)', 'Malegaon', 'Nandgaon', 'Chandwad', 'Niphad', 'Sinnar', 'Yeola'],
'Osmanabad':
    ['Osmanabad', 'Tuljapur', 'Bhum', 'Paranda', 'Washi', 'Kalamb', 'Lohara', 'Umarga'],
'Palghar ':
    ['Palghar', 'Vasai', 'Dahanu', 'Talasari', 'Jawhar', 'Mokhada', 'Vada', 'Vikramgad'],
'Parbhani ':
    ['Parbhani', 'Sonpeth', 'Gangakhed', 'Palam', 'Purna', 'Sailu', 'Jintur', 'Manwath', 'Pathri'],
'Pune ':
    ['Pune', 'Haveli', 'Khed (Rajgurunagar)', 'Junnar', 'Ambegaon (Ghodegaon)', 'Maval (Vadgaon)', 'Mulshi (Paud)', 'Shirur', 'Purandhar (Saswad)', 'Velhe', 'Bhor', 'Baramati', 'Indapur', 'Daund'],
'Raigad ':
    ['Pen', 'Alibaug', 'Murud', 'Panvel', 'Uran', 'Karjat (Matheran)', 'Khalapur', 'Mangaon', 'Tala', 'Roha', 'Sudhagad (Pali)', 'Mahad', 'Poladpur', 'Shrivardhan', 'Mhasla'],
'Ratnagiri ':
    ['Ratnagiri', 'Sangameshwar', 'Lanja', 'Rajapur', 'Chiplun', 'Guhagar', 'Dapoli', 'Mandangad', 'Khed'],
'Sangli ':
    ['Miraj', 'Kavathe-Mahankal', 'Tasgaon', 'Jat', 'Walwa (Islampur)', 'Shirala', 'Khanapur-Vita', 'Atpadi', 'Palus', 'Kadegaon'],
'Satara ':
    ['Satara', 'Jaoli', 'Koregaon', 'Wai', 'Mahabaleshwar', 'Khandala', 'Phaltan', 'Maan (Dahiwadi)', 'Khatav (Vaduj)', 'Patan', 'Karad'],
'Sindhudurg ':
    ['Kankavli', 'Vaibhavwadi', 'Devgad', 'Malwan', 'Sawantwadi', 'Kudal', 'Vengurla', 'Dodamarg'],
'Solapur ':
    ['Solapur North', 'Barshi', 'Solapur South', 'Akkalkot', 'Madha', 'Karmala', 'Pandharpur', 'Mohol', 'Malshiras', 'Sangole', 'Mangalvedhe'],
'Thane ':
    ['Thane', 'Kalyan', 'Murbad', 'Bhiwandi', 'Shahapur', 'Ulhasnagar', 'Ambarnath'],
'Wardha ':
    ['Wardha', 'Deoli', 'Seloo', 'Arvi', 'Ashti', 'Karanja', 'Hinganghat', 'Samudrapur'],
'Washim ':
    ['Washim', 'Malegaon', 'Risod', 'Mangrulpir', 'Karanja', 'Manora'],
'Yavatmal ':
    ['Yavatmal', 'Arni', 'Babhulgaon', 'Kalamb', 'Darwha', 'Digras', 'Ner', 'Pusad', 'Umarkhed', 'Mahagaon', 'Kelapur (Pandharkawada)', 'Ralegaon', 'Ghatanji', 'Wani', 'Maregaon', 'Zari Jamani']}

window.onload = function () {
//Variables
var districtSel = document.getElementById("DistrictSel");
var talukaSel = document.getElementById("TalukaSel");
//set district
for (var district in data) {
    districtSel.options[districtSel.options.length] = new Option(district, district);
}

districtSel.onchange = function () {
    talukaSel.length=1;//reset list
    if (this.selectedIndex < 1) return; // done
    var district = data[districtSel.value];
    //alert(district);
    for (var i = 0; i < district.length; i++) {
    talukaSel.options[talukaSel.options.length] = new Option(district[i], district[i]);
    }
}
}

//distict taluka dropDown_list code end

//NewLandRec leave page alert
window.onbeforeunload = function(){
return 'Are you sure you want to leave?';
};
//NewLandRec leave page alert end


//time Timestamp


//time stmap code end

//captcha code start
var code;
function createCaptcha() {
  //clear the contents of captcha div first
  document.getElementById('captcha').innerHTML = "";
  var charsArray =
  "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  var lengthOtp = 6;
  var captcha = [];
  for (var i = 0; i < lengthOtp; i++) {
    //below code will not allow Repetition of Characters
    var index = Math.floor(Math.random() * charsArray.length + 1); //get the next character from the array
    if (captcha.indexOf(charsArray[index]) == -1)
      captcha.push(charsArray[index]);
    else i--;
  }
  var canv = document.createElement("canvas");
  canv.id = "captcha";
  canv.width = 150;
  canv.height = 50;
  var ctx = canv.getContext("2d");
  ctx.font = "25px Georgia";
  ctx.strokeText(captcha.join(""), 0, 30);
  //storing captcha so that can validate you can save it somewhere else according to your specific requirements
  code = captcha.join("");
  document.getElementById("captcha").appendChild(canv); // adds the canvas to the body element
}

function validateCaptcha() {
  event.preventDefault();
  //debugger
  if (document.getElementById("cpatchaTextBox").value == code) {
    alert("Valid Captcha");
    return true;
  }else{
    alert("Invalid Captcha. try Again");
    createCaptcha();
      return false;
  }
}
//captcha code end
