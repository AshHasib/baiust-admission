package com.example.hasib.baiustadmission;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminActivity extends AppCompatActivity {
    Toolbar toolbar;
    ActionBar actionBar;

    String chancellorDetails="Mr. Md. Abdul Hamid was born on 1 January, 1944 in Kamalpur of Mithamoin Upazila under Kishoregonj district. His father’s name is Late Hazi Md. Tayeb Uddin and mother’s name is Late Tomiza Khatun.\n" +
            "\n" +
            "Mr. Md. Abdul Hamid passed his Matriculation from Nikli G.C. High School and both I.A and B.A from Gurudayal College of Kishoregonj. He obtained Bachelor of Law degree from Central Law College under Dhaka University. Afterwards, he started his profession as a Lawyer.\n" +
            "\n" +
            "Mr. Md. Abdul Hamid joined Chhatra League in 1959 and thereby his political career began. While studying in the college, he took leading part in anti-Ayub Movement in 1961. He was imprisoned by the then Pakistan Government in 1962 for his active participation in the student movement and opposing Hamoodur Rahman Education Commission Report. In 1962-63, he was elected General Secretary of Student Union in Gurudayal College of Kishoregonj and in 1965-66 the Vice-President of the same student union. Mr Hamid was the Founder President of Chhatra League of Kishoregonj Sub-division Unit in 1964 and also elected the Vice-President of Chhatra League of Mymensingh District Unit in 1966-67. He was again imprisoned in 1968 for leading student movement. Towards the end of 1969, he joined Awami League.\n" +
            "\n" +
            "In 1971, on being instructed by Bangabandhu Sheikh Mujibur Rahman, he started the movement in Kishoregonj amid tumultuous protest against Pakistani regime to create public opinion in favour of independence. In the wake of movement, he hoisted the flag of independent Bangladesh inscribed with the map in a huge student gathering at Rothkhala field in Kishoregonj on March17, 1971 in which thousands of students and people participated. On receiving the historic proclamation of the Father of the Nation Bangabandhu for independence through a telegraphic message in the morning of 26 March in 1971, he instantly joined the Liberation War. With the cooperation of Bangalee Army officers in the early part of April 1971, Mr. Hamid procured approximately tk. 11 Crore and 78 lac from Kishoregonj, Bhairab and Bazitpur branches of National Bank of Pakistan and deposited the whole amount safely in the National Bank of Pakistan at its Brahmanbaria Branch considering that as a safe place of custody at that time for using it for the War of Liberation.\n" +
            "\n" +
            "Thereafter, he went to Agartola, India to take part directly in the War of Liberation. At that time, most of the Members of Parliament of greater Chittagong, Noakhali and Comilla had been staying there. Mr. Hamid discussed various strategies of Liberation War with them. Side by side, he exchanged views with the local public representatives and high government officials in Agartola. Later, towards the end of April, he again came back to Bangladesh to further organize people and went back to India. Taking several associates with him, he reached Balat via Tekarhat, Gumaghat, Panchara and Moilam of Meghalaya. He set a Youth Reception Camp in Balat for those who came from Bangladesh to participate in the Liberation War. He was the Chairman of that camp. The primary recruitment of the youth who came from Kishoregonj, Netrokona and Sunamgonj to join the war as freedom fighters, was mainly done in this camp. He was also one of the prominent members of Zonal Administrative Council constituted at Meghalaya to direct the Liberation War and for the better management of the refugees. He also acted as the sub-sector commander of Bangladesh Liberation Force (Mujib Bahini) for Kishoregonj and Sunamgonj Districts. He carried out those responsibilities for the entire period of Liberation War. After the victory of liberation war on 16 December, 1971 he organized meeting at various refugee camps in Meghalaya to motivate the Bangalees who took refuge there to return home. After the homecoming of the refugees, he returned to the country on 10 January 1972.\n" +
            "\n" +
            "Mr. Abdul Hamid became the Chairman of Kishoregonj District Relief & Rehabilitation Committee in Independent Bangladesh. In 1974, he was elected Vice-President of Kishoregonj District Awami League. During 1976-1978, Mr. Hamid was imprisoned by the then Military Government after the brutal killing of the Father of the Nation Bangabandhu Sheikh Mujibur Rahman. He was the President of Kishoregonj District Awami League from 1978 to 2009 and was the President of Kishoregonj District Bar Association for 5 times during the period 1990-96.\n" +
            "\n" +
            "In the Pakistan National Assembly Election of 1970, Mr. Hamid was elected the junior most member from Mymensingh-18 Constituency. In 1972 he became the Member of Constituent Assembly (The Constituent Assembly was formed with the members of National Assembly and Provincial Assembly elected in the historic general election of 1970). As a pro-people and grass-root level popular leader of Bangladesh Awami League, he was elected Member of Parliament for several times. In the General Election of 1973, 1986, 1991, 1996, 2001 and 2009 he was elected Member of Parliament from Kishoregonj-5 Constituency as a nominee of Bangladesh Awami League.\n" +
            "\n" +
            "Mr. Md Abdul Hamid was unanimously elected the Deputy Speaker in the Seventh Parliament on 13 July, 1996 and held the post till 10 July, 2001 .Later he became the Speaker of the Parliament on 12 July 2001 and remained so till 28 October 2001. In the Eighth Parliament he served as the Deputy Leader of the Opposition from 01 November, 2001 to 27 October 2006.\n" +
            "\n" +
            "Mr. Hamid was elected the Speaker in the Ninth Parliament and served office in this capacity during the period 2009-2013. He was also the Chairman of Working Committee, Standing Committee for Rules and Procedure, Standing Committee for Special Rights and Petition Committee of the Parliament.\n" +
            "\n" +
            "Mr. Md Abdul Hamid is an ardent social worker and a patron of education and culture. He established a good number of schools, colleges and madrashas in his constituency including Mithamoin Tomiza Khatun Girls’ High School, Mithamoin Hazi Tayeb Uddin Boys’ High School, Mithamoin College, Astogram College, Alongzuri High School, Itna Girls’ High School, Baribari High School, Abdullahpur High School, Abdul Wadud High School, Kishoregonj Girls’ High School, Dhonpur High School, Shohid Smrity High School, Mohantala High School and Ghagra Abdul Goni High School and many other junior level Schools & Madrashas.\n" +
            "\n" +
            "As a member of Sustainable Development Committee of Inter Parliamentary Union (IPU) from 1997 to 2000 and the member of the Executive Committee of IPU from 2011 to 2013, Mr. Hamid played his due role. He was also the member of the Executive Committee for Commonwealth Parliamentary Association (CPA) for two terms from 1999 to 2001 and from 2009 to 2012. He is the Life Member of Kishoregonj District Public Library, District Shilpakala Academy, Red Crescent Society and Kishoregonj Rifles Club respectively. He is also the honorary member of Kishoregonj Press Club and associated with many other philanthropic institutions.\n" +
            "\n" +
            "A widely travelled person, Mr. Hamid visited USA, UK, Russia, Canada, India, Gibraltar, Barbados, Egypt, Singapore, UAE, Thailand, Morocco, Saudi-Arabia, South Africa, Namibia, Switzerland, Hong-Kong, Kuwait, Iran, South Korea, Mongolia, China, Sweden, Fiji, Australia, Kiribati, France, Germany, Italy, Netherlands, Belgium, Malaysia, Sri Lanka, Pakistan, Japan, Nauru, Maldives, Uganda, Thailand, Bolivia etc. to attend meetings, seminars, symposiums and conferences as a Member of Parliament, as the Deputy Speaker and the Speaker of Bangladesh Parliament.\n" +
            "\n" +
            "For his outstanding contribution to our Independence and Liberation War, Mr. Md. Abdul Hamid was conferred the Independence Award-2013, the highest award of the country.\n" +
            "\n" +
            "Mr. Md. Abdul Hamid became President in-charge on 14 March 2013 as the then President Md. Zillur Rahman was under treatment in Singapore. After the death of Md. Zillur Rahman on 20 March 2013 in Singapore, Mr. Hamid became Acting President from that day. Later Md. Hamid was elected President uncontested as the 22nd President of Bangladesh on 22 April 2013. He was sworn in to the office of the President of the People’s Republic of Bangladesh on 24 April 2013.\n" +
            "\n" +
            "Mr. Hamid is married and father of three sons and a daughter. Reading books on history and constitutions of different countries is his favorite pastime.";



    String vcDetails="Resume of\n" +
            "\n" +
            "BRIGADIER GENERAL K M Salzar Hossain, ndc, psc\n" +
            "\n" +
            "Hon’ble Vice Chancellor of the Bangladesh Army International University of Science and Technology \n" +
            "\n" +
            "Brigadier General K M Salzar Hossain, ndc, psc was commissioned in Bangladesh Army in the Corps of Engineers. The officer had his early Schooling/education in Rajshahi Cadet College. He graduated from CU in 1984. On completion of his basic courses on military engineering, Brigadier General Salzar was sent to BUET to complete his graduation in CE. Accordingly he completed his studies in CE in 1993. Later he completed MSc in Engineering from BUET in 2001.\n" +
            "\n" +
            " During his services in Bangladesh Army, Brigadier General Salzar was posted as a Lec and Asst Prof in the School of Military Engineering at Qadirabad Cantonment. He was again posted at MIST as an Asst and Assoc Prof in the Dept of CE. He also held the appointment of Prof and Dean of the Faculty of CE and the Head of the Dept of Architecture at MIST. His area of studies/teaching included Structural Engineering, Environment Engineering, Water Resources Engineering, Hydraulic Structures, Sediment Transport, Project Planning & Management. As a part of training, in Bangladesh Army, Brigadier General Salzar attended the Staff Courses in Defence Service Command and Staff College and obtained Masters in Defence Studies from National University. He also studied in National Defence College and obtained Masters of Strategic and Development Studies from BUP.\n" +
            "\n" +
            " Besides his services in the various School and Institutions, Brigadier General Salzar had the privilege of serving in some of the coveted command and staff positions. He served as the Project Director, Construction of Server Stations for Electoral Database, Election Commission, Bangladesh and also Project Director, Road Construction Projects in Chittagong Hill Tracts. He commanded a Bangladesh Engineer Contingent in UNMIL, Liberia and an Engineer Battalion in Bangladesh Army.\n" +
            "\n" +
            " Brigadier General Salzar is also a widely travelled person and visited Angola, China, England, KSA, Kuwait, Liberia, Malaysia, Namibia, Sierra Leon, Singapore, South Africa, South Korea, Thailand, Vietnam and Zimbabwe.";

    String bot="Members:\n\nLieutenant General Md Shamsul Haque, psc\n\nLieutenant General Md Shafiqur Rahman, OSP, SCC, afwc, psc" +
            "\n\n Major General Mohammad Humayun Kabir,SUP,RCDS,psc\n\nMajor General Md Abu Sayed Siddique, SPP, afwc, psc, PhD" +
            "\n\nMajor General Md Siddiqur Rahman Sarker, SGP, hdmc, psc\n\nMajor General Ahmed Tabrej Shams Chowdhury, ndc, psc" +
            "\n\nMajor General Md Emdad-Ul-Bari, ndc, psc, te\n\nMajor General Md Abul Khair, ndc, PEng" +
            "\n\nBRIGADIER GENERAL K M Salzar Hossain, ndc, psc\n\nBrigadier General Nahidul Islam Khan, BSP, ndc, psc," +
            "\n\nBrigadier General Md habib Ullah, SPP, ndc, afwc, psc\n\nColonel Dewan Md Liaqat Ali";

    String syndicate="Members:\n\nBrigadier General Khondoker Farid Hassan, ndc\n\nBRIGADIER GENERAL MD HABIB ULLAH, SPP, NDC, AFWC, PSC\n\n" +
            "Colonel Md Sajjad Hossain, afwc, psc\n\nProfessor Nizamuddin Ahmed, PhD\n\nProfessor Dr. Mohammad Abdul Hakim\n\nDr. Wahida Zaman Loskor" +
            "\n\nCol A H M Kamal, afwc, psc, (Retd)";

    String message="Bangladesh Army International University of Science and Technology " +
            "(BAIUST) has stepped into 4th year. The 1st batches will be graduating within a year. " +
            "At this time, I consider myself blessed to be appointed as" +
            " the 2nd Vice Chancellor of BAIUST. However, the " +
            "blessing has its allied responsibilities also. The responsibilities " +
            "of preparing educated future leaders with sound technical/administrative education," +
            " gradually developing BAIUST as a true Center of Excellence in research and education," +
            " building strong ethical values within faculty members and students, all contributing towards" +
            " national development. With the blessings from Almighty Allah and sincere assistance from all," +
            " I truly believe that BAIUST will remain committed in transforming its VISION and MISSION statements" +
            " into reality. Soon, the BAIUST graduates will be proud of their institution, in sha Allah.";

    String acamedic="Members:\n\nProfessor Nizamuddin Ahmed, PhD\n\nProfessor Kamrul Hasan\n\n" +
            "Professor Md Amanullah\n\nProfessor Mohammad Mafizur Rahman\n\nProfessor Mohammad Shamsul Arefin" +
            "\n\nDr. Wahida Zaman Loskor\n\nMr. Golam Muktadir Nayeem\n\nDr. Umma Hany\n\nM. M. Fayzul Kabir\n\n" +
            "Mr. Aohammad Ataullah Nuri\n\nCol A H M Kamal, afwc, psc, (Retd)";


    String financial="Members:\n\nBRIGADIER GENERAL KHONDOKER FARID HASSAN, NDC\n\nBRIGADIER GENERAL MD HABIB ULLAH, SPP, NDC, AFWC, PSC\n\n" +
            "BRIGADIER GENERAL K M Salzar Hossain, ndc, psc\n\nColonel Md Sajjad Hossain, afwc, psc\n\n" +
            "Mohammad Saif Uddin, CISA, FCA\n\nJafor Ahmed";

    String planResearch="Members:\n\nBRIGADIER GENERAL K M Salzar Hossain, ndc, psc\n\n" +
            "BRIGADIER GENERAL MD HABIB ULLAH, SPP, NDC, AFWC, PSC\n\nColonel Md Sajjad Hossain, afwc, psc\n\n" +
            "Dr. Wahida Zaman Loskor\n\nGOLAM MOKTADER NAYEEM\n\nJAFOR AHMED\n\nM. M. Fayzul Kabir";


    private CardView chancellor,viceChancellor,boardOfTrustees,finComitee,syndicates,academCouncil,planningResearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        toolbar=findViewById(R.id.adminToolbar);
        setSupportActionBar(toolbar);
        actionBar=getSupportActionBar();
        actionBar.setTitle("Administration");
        actionBar.setDisplayHomeAsUpEnabled(true);


        CardView vcMessage=findViewById(R.id.messageVcSection);
        vcMessage.setOnClickListener(v->{

            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(AdminActivity.this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(AdminActivity.this);
            }
            builder.setTitle("Message from VC")
                    .setMessage(message)
                    .setPositiveButton("Previous", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                        }
                    }).show();
        });

        chancellor=findViewById(R.id.chancellor);
        chancellor.setOnClickListener(v->{
            Intent intent=new Intent(AdminActivity.this,ShowInfo.class);
            intent.putExtra("Title","Mr. Md. Abdul Hamid");
            intent.putExtra("Designation","Hon’ble President of the People’s Republic of Bangladesh ");
            intent.putExtra("Description",chancellorDetails);
            startActivity(intent);
        });

        viceChancellor=findViewById(R.id.viceChancellor);
        viceChancellor.setOnClickListener(v->{

            Intent intent=new Intent(AdminActivity.this,ShowInfo.class);
            intent.putExtra("Title","BRIG. GEN. K. M. SALZAR HOSSAIN");
            intent.putExtra("Designation","Vice Chancellor");
            intent.putExtra("Description",vcDetails);
            startActivity(intent);
        });

        boardOfTrustees=findViewById(R.id.boardOfTrustees);
        boardOfTrustees.setOnClickListener(v->{
            Intent intent=new Intent(AdminActivity.this,ShowInfo.class);
            intent.putExtra("Title","General Aziz Ahmed, BGBM, PBGM, BGBMS, psc, G");
            intent.putExtra("Designation","Chairman");
            intent.putExtra("Description",bot);
            startActivity(intent);
        });

        syndicates=findViewById(R.id.syndicates);
        syndicates.setOnClickListener(v->{
            Intent intent=new Intent(AdminActivity.this,ShowInfo.class);
            intent.putExtra("Title","BRIG. GEN. K. M. SALZAR HOSSAIN");
            intent.putExtra("Designation","Vice Chancellor");
            intent.putExtra("Description",syndicate);
            startActivity(intent);
        });
        academCouncil=findViewById(R.id.academicCouncil);
        academCouncil.setOnClickListener(v->{
            Intent intent=new Intent(AdminActivity.this,ShowInfo.class);
            intent.putExtra("Title","BRIG. GEN. K. M. SALZAR HOSSAIN");
            intent.putExtra("Designation","Vice Chancellor");
            intent.putExtra("Description",acamedic);
            startActivity(intent);
        });



        finComitee=findViewById(R.id.financialComitee);
        finComitee.setOnClickListener(v->{
            Intent intent=new Intent(AdminActivity.this,ShowInfo.class);
            intent.putExtra("Title","Major General Ahmed Tabrej Shams Chowdhury, ndc, psc");
            intent.putExtra("Designation","Chairman, Finance Committee");
            intent.putExtra("Description",financial);
            startActivity(intent);
        });


        planningResearch=findViewById(R.id.planningResearch);
        planningResearch.setOnClickListener(v->{
            Intent intent=new Intent(AdminActivity.this,ShowInfo.class);
            intent.putExtra("Title","Major General Ahmed Tabrej Shams Chowdhury, ndc, psc");
            intent.putExtra("Designation","Chairman, Research & Development Committee");
            intent.putExtra("Description",planResearch);
            startActivity(intent);
        });

    }
}
