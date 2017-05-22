#include <iostream>
#include <string.h>
#include <time.h>
#include <vector>
#include <algorithm>

using namespace std;

class movie {
      public:
      string id,name;
      int duration,s;
      long price;
      struct seat{
             bool status;
             };
      struct showtime{
             int hour,min;
             };
      struct session{
             showtime time;
             seat kursi[200];
             int iseat;
             };
      struct tempat{
             string name;
             session sesi[20];
             }venue;

      };

class admin {
      private:
      int i,j;
      string id,name,password,a,b,c;
      bool loginStatus;
      
      public:
      admin(string a,string b,string c):id(a),password(b),name(c){loginStatus=false;}
      void addMovie(movie * a){if(loginStatus){
                               cout<<endl<<id<<" addMovie";
                               cin.ignore();
                               cout<<"\nmovie name: ";getline(cin,a->name);
                               cout<<"movie id: ";cin>>a->id;
                               cout<<"movie price: ";cin>>a->price;
                               cout<<"movie venue: ";cin>>a->venue.name;
                               cout<<"movie duration: ";cin>>a->duration;
                               cout<<"movie number session: ";cin>>a->s;
                               
                               a->venue.sesi[0].time.hour=9;a->venue.sesi[0].time.min=0;
                               for(j=0;j<100;j++)a->venue.sesi[0].kursi[j].status=true;
                               for(i=1;i<a->s;i++){
                                                 a->venue.sesi[i].time.min=(a->venue.sesi[i-1].time.min+(a->duration%60))%60;
                                                 a->venue.sesi[i].time.hour=(a->venue.sesi[i-1].time.hour+(a->duration/60))%24;
                                                 a->venue.sesi[i].iseat=0;
                                                 for(j=0;j<100;j++)a->venue.sesi[i].kursi[j].status=true;
                                                 //for(j=0;j<100;j++)cout<<"nomor kursi: "<<j<<" status: "<<a->venue.sesi[i].kursi[j].status<<endl;
                                                 }
                                                 }
                               else cout<<"\nlogin dahulu"<<endl;
                               }
      void viewMovie(movie * a){
                                if(!a->id.empty()){
                                cout<<endl<<id<<" viewMovie";
                               cout<<"\nmovie name: "<<a->name;
                               cout<<"\nmovie id: "<<a->id;
                               cout<<"\nmovie duration: "<<a->duration<<" menit";
                               cout<<"\nmovie price: Rp."<<a->price;
                               cout<<"\nmovie venue: "<<a->venue.name;
                               for(i=0;i<a->s;i++)cout<<"\nsesi "<<i<<" : "<<a->venue.sesi[i].time.hour<<":"<<a->venue.sesi[i].time.min;
                               cout<<endl;
                               }
                                }
      void updateData(){
                             if(loginStatus){
                             cout<<endl<<id<<" updateData";
                             cout<<"\nadmin pass: ";cin>>password;
                             cin.ignore();
                             cout<<"admin name: ";getline(cin,name);
                             }
                             else cout<<"\nlogin dahulu"<<endl;
                             }
      void deleteMovie(movie * a){
                                  if(loginStatus){
                                  delete a;
                                  }else cout<<"\nlogin dahulu"<<endl;
                                  }
      void login(){
                   cout<<endl<<"login";
                   cout<<"\nadmin username: ";cin>>a;
                   cout<<"admin password: ";cin>>b;
                   if(id==a && password==b && !loginStatus){
                                                            cout<<"\nlogin sukses"<<endl;
                                                            loginStatus=1;
                                                            }
                   else cout<<"\nlogin gagal"<<endl;
                   }
      void logout(){cout<<"\nadmin logout"<<endl;loginStatus=0;}
      };

class registeredUser{
      public:
      int i;string a,b;
      string username,password,name;
      bool loginStatus;
      long wallet;
      static int ipayment,iorder;
      time_t rawtime;
      
      struct showtime{
             int hour,min;
             };
      
      struct payment{
             string bankID,methode;
             long price;
             bool status;
             struct tm * date;
             }dbpayment[1000];
             
      struct order{
             showtime time;
             string movie;
             long price,seat,sesi;
             bool status;
             struct tm * date;
             }dborder[1000];
      void login(){
                   cout<<endl<<"login";
                   cout<<"\nmember username: ";cin>>a;
                   cout<<"member password: ";cin>>b;
                   if(username==a && password==b && !loginStatus){
                                                            cout<<"\nlogin sukses"<<endl;
                                                            loginStatus=1;
                                                            }
                   else cout<<"\nlogin gagal"<<endl;
                   }
      void logout(){cout<<endl<<username<<" logout"<<endl;loginStatus=0;}
      void status(){
                    if(loginStatus){
                    cout<<"\nusername : "<<username<<endl;
                    cout<<"name : "<<name<<endl;
                    cout<<"wallet : "<<wallet<<endl;
                    }else cout<<"\nlogin dahulu\n";
                    }
      
      void fillWallet(){
                        if(loginStatus){
                        cout<<endl<<username<<" fillWallet";
                        cout<<"\nid payment : "<<ipayment;
                        cout<<"\ninput jumlah nominal : ";cin>>dbpayment[ipayment].price;
                        cout<<"input methode : ";cin>>dbpayment[ipayment].methode;
                        dbpayment[ipayment].status=false;
                        if(dbpayment[ipayment].methode=="e-banking"){cout<<"\tinput id e-banking : ";cin>>dbpayment[ipayment].bankID;}
                        else {cout<<"\tinput nomor rekening : ";cin>>dbpayment[ipayment].bankID;}
                        cout<<endl;
                        ipayment++;
                        }else cout<<"\nlogin dahulu\n";
                        }
      void makeWalletPayment(){
                         if(loginStatus){      
                         int idpayment;
                         cout<<endl<<username<<" makeWalletPayment";
                         cout<<"\ninput id payment : ";cin>>idpayment;
                         
                         if(dbpayment[idpayment].price!=0){
                         dbpayment[idpayment].status=true;
                         cout<<"\nwallet anda telah bertambah sebesar "<<dbpayment[idpayment].price<<endl;
                         wallet+=dbpayment[idpayment].price;
                         }else cout<<"\ntidak ada order pada idpayment "<<idpayment<<endl;
                         
                         }else cout<<"\nlogin dahulu\n";
                         }
      void makeOrder(movie * a){
                           if(loginStatus){ 
                           int b,c;
                           cout<<endl<<username<<" makeOrder "<<a->name;
                           cout<<"\nid order : "<<iorder;
                           cout<<"\ninput order sesi : ";cin>>dborder[iorder].sesi;b=dborder[iorder].sesi;
                           cout<<"input order seat : ";cin>>dborder[iorder].seat;c=dborder[iorder].seat;
                           if(a->venue.sesi[b].kursi[c].status)a->venue.sesi[b].kursi[c].status=false;
                           else{
                                while(!a->venue.sesi[b].kursi[c].status){
                                                                         cout<<"order gagal kursi telah dipesan"<<endl;
                                                                         cout<<"input order seat : ";cin>>dborder[iorder].seat;c=dborder[iorder].seat;
                                                                         }
                                a->venue.sesi[b].kursi[c].status=false;
                                }
                           
                           cout<<endl;
                           dborder[iorder].time.hour=a->venue.sesi[dborder[iorder].sesi].time.hour;
                           dborder[iorder].time.min=a->venue.sesi[dborder[iorder].sesi].time.min;
                           dborder[iorder].movie=a->name;
                           dborder[iorder].price=a->price;
                           dborder[iorder].status=false;
                           dborder[iorder].date=localtime(&rawtime);
                           iorder++;
                           }else cout<<"\nlogin dahulu\n";
                       }
      void makeOrderPayment(){
                         if(loginStatus){      
                         int idorder;
                         
                         cout<<endl<<username<<" makeOrderPayment "<<dborder[iorder].movie;
                         cout<<"\nid payment : "<<ipayment;
                         cout<<"\ninput id order : ";cin>>idorder;
                         
                         dbpayment[ipayment].price=dborder[idorder].price;
                         time(&rawtime);
                         dbpayment[ipayment].date=localtime(&rawtime);
                         
                         if(dborder[idorder].price!=0){
                         cout<<"input methode : ";cin>>dbpayment[ipayment].methode;
                         if(dbpayment[ipayment].methode=="e-banking"){cout<<"\tinput id e-banking : ";cin>>dbpayment[ipayment].bankID;}
                         else if(dbpayment[ipayment].methode=="wallet"){wallet-=dbpayment[ipayment].price;}
                         else {cout<<"\tinput nomor rekening : ";cin>>dbpayment[ipayment].bankID;}
                         dbpayment[ipayment].status=true;
                         dborder[idorder].status=true;
                         cout<<"order "<<idorder<<" telah terbayar"<<endl;
                         ipayment++;
                         }else cout<<"\ntidak ada order pada idorder "<<idorder<<endl;
                         
                         }else cout<<"\nlogin dahulu\n";
                         }
      void purchaseHistory(){
                       if(loginStatus){
                       cout<<endl<<username<<" purchaseHistory"<<endl;     
                       for(i=0;i<iorder;i++){
                                             if(dborder[i].status=true){
                                                                              cout<<"\nidorder: "<<i;
                                                                              cout<<"\nmovie: "<<dborder[i].movie;
                                                                              cout<<"\nshow time: "<<dborder[i].time.hour<<":"<<dborder[i].time.min;
                                                                              cout<<"\nseat number: "<<dborder[i].seat<<endl;
                                                                              }
                                             
                                             }
                       }else cout<<"\nlogin dahulu\n";
                       }
      void viewMovie(movie * a){
                                if(!a->id.empty()){
                               cout<<endl<<username<<" viewMovie";
                               cout<<"\nname: "<<a->name;
                               cout<<"\nid: "<<a->id;
                               cout<<"\nduration: "<<a->duration<<" menit";
                               cout<<"\nprice: Rp."<<a->price;
                               cout<<"\nvenue: "<<a->venue.name;
                               for(i=0;i<a->s;i++)cout<<"\nsesi "<<i<<" : "<<a->venue.sesi[i].time.hour<<":"<<a->venue.sesi[i].time.min;
                               cout<<endl;
                               }
                                }
      }member[1000];

class unregisteredUser{
      int i,j;
      public:
      static int id;
      string ipAddress;
      unregisteredUser(string a):ipAddress(a){}
      void viewMovie(movie * a){
                                if(!a->id.empty()){
                               cout<<endl<<ipAddress<<" viewMovie";
                               cout<<"\nname: "<<a->name;
                               cout<<"\nid: "<<a->id;
                               cout<<"\nduration: "<<a->duration<<" menit";
                               cout<<"\nprice: Rp."<<a->price;
                               cout<<"\nvenue: "<<a->venue.name;
                               for(i=0;i<a->s;i++){
                               cout<<"\nsesi "<<i<<" : "<<a->venue.sesi[i].time.hour<<":"<<a->venue.sesi[i].time.min;
                               //for(j=0;j<100;j++)cout<<"nomor kursi: "<<j<<" status: "<<a->venue.sesi[i].kursi[j].status<<endl;
                               }
                               cout<<endl;
                               }
                                }
      void Register(){
                      cout<<endl<<ipAddress<<" register";
                      cout<<"\nusername: ";cin>>member[id].username;
                      cout<<"password: ";cin>>member[id].password;
                      cin.ignore();
                      cout<<"name: ";getline(cin,member[id].name);
                      cout<<endl;
                      member[id].loginStatus=0;
                      member[id].wallet=0;
                      member[id].ipayment=0;
                      member[id].iorder=0;
                      id++;
                      }
      
      };

int unregisteredUser::id=0;
int registeredUser::ipayment=0;
int registeredUser::iorder=0;

int main(){
    movie a,b;
    admin mulyahadi("admin","admin","hadi");
    mulyahadi.login();
    mulyahadi.addMovie(&a);
    
    unregisteredUser guest("192.168.1.1");
    guest.viewMovie(&a);
    guest.Register();
    
    member[0].login();
    member[0].status();
    member[0].fillWallet();
    member[0].makeWalletPayment();
    member[0].status();
    member[0].makeOrder(&a);
    member[0].makeOrderPayment();
    member[0].status();
    member[0].makeOrder(&a);
    member[0].makeOrderPayment();
    member[0].status();
    member[0].purchaseHistory();
    
    system("PAUSE");
    return 0;
    }
